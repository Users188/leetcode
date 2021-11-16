package Trees;
/*leetcode:二叉树每层的最大值*/
import java.util.*;

public class LargestValues {
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
}
