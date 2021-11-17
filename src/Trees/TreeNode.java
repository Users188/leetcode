package Trees;

import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static TreeNode createBinaryTree(List<Integer> values) {
        if (values == null || values.isEmpty()) {//最简单问题
            return null;
        }
        TreeNode root = null;
        Integer value = values.remove(0);
        if (value != null) {
            root = new TreeNode(value);
            root.left = createBinaryTree(values);
            root.right = createBinaryTree(values);
        }
        return root;
    }
}
