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


}
