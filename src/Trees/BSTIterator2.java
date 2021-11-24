package Trees;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator2 {
    TreeNode pointer;
    Deque<TreeNode> stack;

    public BSTIterator2(TreeNode root) {
        stack = new LinkedList<>();
        pointer = root;
    }

    public int next() {
        while (pointer != null) {
            stack.push(pointer);
            pointer = pointer.left;
        }
        pointer = stack.pop();
        int res = pointer.val;
        pointer = pointer.right;
        return res;
    }

    public boolean hasNext() {
        return pointer != null || !stack.isEmpty();
    }
}
