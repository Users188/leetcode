package Arrays.dp;

/**
 * leetcode:翻转字符
 * 如果一个由 '0' 和 '1' 组成的字符串，、
 * 是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是 单调递增 的。
 * <p>
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 s，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 * <p>
 * 返回使 s 单调递增 的最小翻转次数。
 */
public class FlipsMonoIncr {
    //dp[i][0]表示前i个元素，最后一个元素为0的最小翻转次数；
    //dp[i][1]表示前i个元素，最后一个元素为1的最小翻转次数
    public int minFlipsMonoIncr_dp(String s) {
        int[][] dp = new int[s.length()][2];
        //初始化
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;
        //状态转移
        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = dp[i - 1][0] + (s.charAt(i) == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i) == '1' ? 0 : 1);
        }
        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
    }

    public int minFlipsMonoIncr(String s) {
        int one = 0;
        int flip = 0;
        //要使s单调递增，则需要将s中所有以'10'结尾的子字符串翻转
        for (char c : s.toCharArray()) {
            if (c == '0')//选择翻转前面的1(one) or 翻转后面的0(flip+1)
                flip = Math.min(one, flip + 1);
            else
                one++;//记录前面为1的个数
        }
        return flip;
    }
}
