package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

    private void inorder(TreeNode root,List<TreeNode> order){
        //中序遍历
        if (root==null)
            return;
        inorder(root.left,order);
        order.add(root);
        inorder(root.right,order);
    }
}
