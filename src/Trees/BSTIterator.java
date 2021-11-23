package Trees;

import java.util.ArrayList;
import java.util.List;

/*leetcode:二叉搜索树迭代器*/
/*实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器*/
public class BSTIterator {
    private int pointer;
    private List<TreeNode> bst_inorder;
    public BSTIterator(TreeNode root) {
        pointer = 0;
        bst_inorder = new ArrayList<>();
        bst_inorder.add(new TreeNode(0));
        LDR(root);
    }

    public int next() {
        return bst_inorder.get(++pointer).val;
    }

    public boolean hasNext() {
        return pointer+1<bst_inorder.size();
    }

    private void LDR(TreeNode root){
        if (root==null)
            return;
        LDR(root.left);
        bst_inorder.add(root);
        LDR(root.right);
    }
}
