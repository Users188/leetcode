package Trees;

import java.util.*;

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
//        System.out.println(root.val+" "+depth);
        //优先右侧
        dfs(rightSideView, root.right, depth + 1);
        dfs(rightSideView, root.left, depth + 1);

    }

    /*leetcode:从从根节点到叶节点的路径数字之和*/
    public int sumNumbers(TreeNode root) {
        Queue<TreeNode> levelNodes = new LinkedList<>();
        Queue<StringBuilder> numberString = new LinkedList<>();
        levelNodes.add(root);
        numberString.add(new StringBuilder().append(root.val));
        Integer sum = 0;
        while (!levelNodes.isEmpty()) {

            TreeNode head = levelNodes.poll();
            StringBuilder number = numberString.poll();

            if (head.left == null && head.right == null) {
                sum += Integer.valueOf(number.toString());
            } else {
                if (head.left != null) {
                    levelNodes.add(head.left);
                    StringBuilder num = new StringBuilder(number.toString());
                    numberString.add(num.append(head.left.val));
                }
                if (head.right != null) {
                    levelNodes.add(head.right);
                    StringBuilder num = new StringBuilder(number.toString());
                    numberString.add(num.append(head.right.val));
                }
            }
        }
        return sum;
    }

    public int sumNumbers_dfs(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null)
            return 0;
        preSum = preSum * 10 + root.val;
        if (root.left == null && root.right == null)
            return preSum;
        else
            return dfs(root.left, preSum) + dfs(root.right, preSum);
    }

    /*leetcode:向下的路径节点之和*/
    /*给定一个二叉树的根节点 root，和一个整数 targetSum ，
    求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
    路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。*/
    //将每个节点的符合targetSum的路径数目相加
    public int pathSum(TreeNode root,int targetSum){
        if (root==null)
            return 0;
        int count=0;
        count+= countByPreSum(root,targetSum,0);
        count+=pathSum(root.left,targetSum);
        count+=pathSum(root.right,targetSum);
        return count;
    }

    //计算从当前节点到各个节点符合targetSum的路径数
    //此处sum变量可以去掉，改为递减逻辑（targetSum-=rootVal）
    private int countByPreSum(TreeNode root, int targetSum, int sum){
        if (root==null)
            return 0;
        int count=0;
        sum+=root.val;
        if (sum==targetSum)
            count++;
        count+= countByPreSum(root.left,targetSum,sum);
        count+= countByPreSum(root.right,targetSum,sum);
        return count;
    }

    public int pathSum_ultimate(TreeNode root,int targetSum){
        HashMap<Integer,Integer> map = new HashMap<>();
        //前缀和首项，和为0出现了一次
        map.put(0,1);
        return countByPreSum(root,targetSum,0,map);
    }
    //map<key:前缀和,value:出现的次数>
    private int countByPreSum(TreeNode root, int targetSum, int sum, HashMap<Integer,Integer> preSum){
        if (root==null)
            return 0;
        int count=0;
        sum+=root.val;

        count=preSum.getOrDefault(sum-targetSum,0);
        preSum.put(sum,preSum.getOrDefault(sum,0)+1);
        count+= countByPreSum(root.left,targetSum,sum,preSum);
        count+= countByPreSum(root.right,targetSum,sum,preSum);
        //因为dfs函数结束时程序会回到当前节点的父节点(L->(D)->R->D)，
        // 所以在返回父节点之前需要将当前节点值从路径中删除，保证左子树和右子树的前缀和在父节点时一致
        // 即哈希表中当前路径值减1。
        preSum.put(sum,preSum.getOrDefault(sum,0)-1);

        return count;
    }


}
