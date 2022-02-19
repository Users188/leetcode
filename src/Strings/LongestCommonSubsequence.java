package Strings;

import java.util.Arrays;

/**
 * leetcode:最长公共子序列
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
 * （也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 提示：
 * <p>
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        //dp[i][j] 表示 text1[0...i]与text2[0...j]的最长公共子序列长度
        //当i=0或j=0时,t1或t2为空字符串，LCS长度为0
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[len1][len2];
    }

    //将空间复杂度降低至O(n)
    //题解参考:https://leetcode-cn.com/problems/longest-common-subsequence/solution/er-wei-shu-zu-dphe-yi-wei-shu-zu-dpde-sh-w96r/
    public int longestCommonSubsequence_modified(String text1, String text2) {
        char[] cs1 = text1.toCharArray();
        char[] cs2 = text2.toCharArray();
        int rows = cs1.length, cols = cs2.length;

        int[] dp = new int[cols + 1];

        for (int row = 1; row <= rows; row++) {
            int leftTop = 0;
            for (int col = 1; col <= cols; col++) {
                int tmp = dp[col];
                if (cs1[row - 1] == cs2[col - 1])
                    dp[col] = leftTop + 1;
                else
                    dp[col] = Math.max(dp[col], dp[col - 1]);

                leftTop = tmp;
            }
        }

        return dp[cols];
    }

}
