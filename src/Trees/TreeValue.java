package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeValue {
    /*leetcode:二叉树每层的最大值*/
    public List<Integer> largestValues(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null)
            return res;
        //储存该层节点数
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        while (!levelNodes.isEmpty()){

            int max=Integer.MIN_VALUE;
            //得到该层节点数
            int count=levelNodes.size();
            //遍历该层
            while (count-- > 0){
                TreeNode head = levelNodes.poll();
                if (head.left!=null)
                    levelNodes.add(head.left);
                if (head.right!=null)
                    levelNodes.add(head.right);
                max=Math.max(max,head.val);
            }
            res.add(max);
        }
        return res;
    }

    /*leetcode:二叉树最底层最左边的值*/
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> levelNodes= new LinkedList<>();
        levelNodes.add(root);
        TreeNode ret=root;
        while (!levelNodes.isEmpty()){
            ret = levelNodes.peek();
            int count = levelNodes.size();
            while (count-- > 0) {
                TreeNode head = levelNodes.poll();
                if (head.left != null)
                    levelNodes.add(head.left);
                if (head.right != null)
                    levelNodes.add(head.right);
            }
        }
        return ret.val;
    }

    /*leetcode:二叉树的有右侧视图*/
    /*即返回二叉树每一层的最后一个节点的值*/
    public List<Integer> rightSideView_bfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        while (!levelNodes.isEmpty()) {
            int count = levelNodes.size();
            while (count-- > 0) {
                TreeNode head = levelNodes.poll();
                if (head.left != null)
                    levelNodes.add(head.left);
                if (head.right != null)
                    levelNodes.add(head.right);
                if (count == 0)
                    res.add(head.val);
            }
        }
        return res;
    }

    public List<Integer> rightSideView_dfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<Integer> rightSideView, TreeNode root, Integer depth) {
        if (root == null)
            return;
        //由于是从右边先开始遍历，进入到该层第一个的节点就是能最右侧的节点
        if (depth == rightSideView.size())
            rightSideView.add(root.val);
        //优先右侧
        dfs(rightSideView, root.right, depth + 1);
        dfs(rightSideView, root.left, depth + 1);

    }

}
