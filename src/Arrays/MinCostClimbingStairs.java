package Arrays;

/**
 * leetcode:爬楼梯的最小成本
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 */
public class MinCostClimbingStairs {
    //动态规划+滚动数组优化
    public int minCostClimbingStairs_dp(int[] cost) {
        int[] dp = new int[3];
        //注意i < cost.length+1
        for (int i = 2; i < cost.length + 1; i++) {
            dp[2] = Math.min(dp[0] + cost[i - 2], dp[1] + cost[i - 1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }

    public int minCostClimbingStairs_recursive(int[] cost) {
        return recursion(cost, cost.length);
    }

    private int recursion(int[] cost, int n) {
        if (n == 0 || n == 1)
            return 0;
        return Math.min(recursion(cost, n - 2) + cost[n - 2], recursion(cost, n - 1) + cost[n - 1]);
    }
}
