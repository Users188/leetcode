package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Tree {

    /*leetcode:二叉树剪枝*/
    /*给定一个二叉树 根节点root，树的每个节点的值要么是 0，要么是 1。
    请剪除该二叉树中所有节点的值为 0 的子树。
    节点 node 的子树为node 本身，以及所有 node的后代。*/
    public TreeNode pruneTree(TreeNode root){
        //后序遍历
        if (root==null)
            return null;
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if (root.val==0 && root.left==null && root.right==null)
            root=null;
        return root;
    }

    /*leetcode:展平二叉搜索树*/
    /*给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
    并且每个节点没有左子节点，只有一个右子节点。*/
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> order =new ArrayList<>();
        inorder(root,order);
        for (int i = 0; i < order.size(); i++) {
            TreeNode node = order.get(i);
            //将所有节点的左孩子设为null
            node.left=null;
            //防止数组越界
            if (i+1<order.size())
                //将右孩子设为数组中后一个节点
                node.right=order.get(i+1);
        }
        return order.get(0);
    }

    private void inorder(TreeNode root, List<TreeNode> order) {
        //中序遍历
        if (root == null)
            return;
        inorder(root.left, order);
        order.add(root);
        inorder(root.right, order);
    }

    /*leetcode:二叉树搜索树中的中继后序*/
    /*给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
    节点p的后继是值比p.val大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。*/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pointer = root;
        boolean flag = false;
        while (pointer != null || !stack.isEmpty()) {
            while (pointer != null) {
                stack.push(pointer);
                pointer = pointer.left;
            }
            if (!stack.isEmpty()) {
                pointer = stack.pop();
                if (flag)
                    return pointer;
                //如果找到了节点p，将flag设为true，会返回其中继后序
                if (pointer == p)
                    flag = true;
                pointer = pointer.right;
            }
        }
        return null;
    }

    public TreeNode inorderSuccessor_ultimate(TreeNode root, TreeNode p) {
        //上面的解法没有利用好二叉搜索树的性质，即L<D<R，现利用该性质
        TreeNode pointer = root;
        TreeNode res = null;
        //节点p的后继是值比p.val大的节点中键值最小的节点
        while (pointer != null) {
            //如果当前节点值大于p，则搜索其左子树（比当前节点小）,并将返回节点设为当前节点
            if (pointer.val > p.val) {
                res = pointer;
                pointer = pointer.left;
            }
            //否则则搜索其右子树
            else
                pointer = pointer.right;
        }
        return res;
    }
}
