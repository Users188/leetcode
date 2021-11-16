package Trees;
/*leetcode:往完全二叉树添加结点*/

import java.util.LinkedList;
import java.util.Queue;

/*最初给定的树是完全二叉树，且包含1到1000个节点。
每个测试用例最多调用CBTInserter.insert操作10000次。
给定节点或插入节点的每个值都在0到5000之间。
*/
public class CBTInserter {
    private final Queue<TreeNode> queue;
    private final TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;

        queue = new LinkedList<>();
        queue.offer(root);
        //在初始化树时就层序遍历到第一个没有左或右子树的节点，即为待插入位置的父节点，在队列头部
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int v) {
        //队列头部节点即为待插入位置的父节点
        TreeNode parent = queue.peek();
        TreeNode node = new TreeNode(v);
        //插入左子树，父节点仍无右子树，父节点不变
        //插入右子树，左右子树入列，并将该父节点出列，待插入位置更改为下一个
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;

            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }

        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}