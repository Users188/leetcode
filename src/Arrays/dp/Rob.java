package Arrays.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Rob {
    /**
     * leetcode:房屋偷盗
     * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     * <p>
     * [5,72,209,143,216,220,122,115,87,227,220,161]
     */
    //dp[0]=0,dp[1]=0,dp[n+1]=max(dp[n],dp[n−1]+num)
    public int rob_dp(int[] nums) {
        return rob_dp(nums, 0, nums.length);
    }

    public int rob_dp(int[] nums, int start, int end) {
        int pre = 0, cur = 0, tmp;
        for (int i = start; i < end; i++) {
            tmp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = tmp;
        }
        return cur;
    }

    public int rob_recursive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        return backtrack(nums, 0, map);
    }

    //返回以start为起点能偷的最大金额
    private int backtrack(int[] nums, int start, Map<Integer, Integer> map) {
        //如果已经遍历过，可以直接从map中得到结果
        if (map.containsKey(start))
            return map.get(start);
        if (start >= nums.length)
            return 0;
        int ans = 0;
        for (int i = start; i < nums.length; i++)
            ans = Math.max(ans, nums[i] + backtrack(nums, i + 2, map));
        //存储start对应的最大金额
        map.put(start, ans);
        return map.get(start);
    }

    //暴力解法
    private void backtrack(int[] nums, int start, int sum, int[] max) {
        if (start >= nums.length) {
            max[0] = Math.max(max[0], sum);
            return;
        }
        backtrack(nums, start + 2, sum + nums[start], max);
        backtrack(nums, start + 1, sum, max);
    }

    /**
     * leetcode:环形房屋偷盗
     * 一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，
     * 今晚能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 3)
            return Arrays.stream(nums).max().getAsInt();
        return Math.max(rob_dp(nums, 0, n - 1), rob_dp(nums, 1, n));
    }
}
