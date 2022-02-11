package Arrays.dp;

/**
 * leetcode:粉刷房子
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，
 * 你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * <p>
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。
 * 每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * <p>
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * 0：红色，1：蓝色，2：绿色
 * <p>
 * 请计算出粉刷完所有房子最少的花费成本。
 * <p>
 * 提示:
 * <p>
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 */
public class PaintHouse {

    int[][] minCosts;

    public static void main(String[] args) {
        int[][] costs = new int[][]{
                {17, 2, 17}, {16, 16, 5}, {14, 3, 19}
        };
        new PaintHouse().minCost_recursive(costs);
    }

    public int minCost_recursive(int[][] costs) {
        minCosts = new int[costs.length][3];
        return getMinCost(costs, 0, -1);
    }

    //记忆化数组
    private int getMinCost(int[][] cost, int index, int preColor) {
        if (index == cost.length)
            return 0;
        if (preColor != -1 && minCosts[index][preColor] != 0)
            return minCosts[index][preColor];
        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < 3; color++) {
            if (color != preColor) {
                minCost = Math.min(minCost, cost[index][color] + getMinCost(cost, index + 1, color));
            }
        }
        if (preColor == -1)
            return minCost;
        //对于房间i,如果其preColor为n,则其最小花费为minCost。
        return minCosts[index][preColor] = minCost;
    }

    public int minCost_dp(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        //第一件房子
        System.arraycopy(costs[0], 0, dp[0], 0, dp[0].length);
        for (int i = 1; i < n; i++) {
            //状态转换
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        int minCost = Integer.MAX_VALUE;
        for (int cost : dp[n - 1]) {
            minCost = Math.min(cost, minCost);
        }
        return minCost;
    }
}
