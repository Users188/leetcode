package Arrays.dp;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * leetcode:最长斐波那契数列
 * <p>
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * <p>
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * <p>
 * （回想一下，子序列是从原序列  arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。
 * 例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 1000
 * 1 <= arr[i] < arr[i + 1] <= 10^9
 */
public class LenLongestFibSubseq {
    public int lenLongestFibSubseq_primitive(int[] arr) {
        int max = 0, n = arr.length;
        int[][] dp = new int[n][n];//dp[i][j] 表示以i,j结尾的斐波那契数列的长度e.g{...i,j}
        Arrays.stream(dp).forEach(ints -> Arrays.fill(ints, 2));//将dp每一项初始化为2，因为斐波那契数列至少需要两个数
        for (int k = 2; k < n; k++) {
            for (int j = k - 1; j > 0; j--) {
                for (int i = j - 1; i >= 0; i--) {
                    if (arr[i] + arr[j] == arr[k]) {
                        dp[j][k] = dp[i][j] + 1;
                    }
                }
                max = Math.max(dp[j][k], max);
            }
        }
        return max >= 3 ? max : 0;
    }

    //暴力解法
    public int lenLongestFibSubseq_modified(int[] arr) {
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        int max = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = arr[j], x2 = arr[i] + arr[j];
                int len = 3;
                while (set.contains(x2)) {
                    int temp = x1;
                    x1 = x2;
                    x2 = x1 + temp;
                    max = Math.max(max, len++);
                }
            }
        }
        return max;
    }

    public int lenLongestFibSubseq(int[] arr) {
        int max = 0, n = arr.length;
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) {
            int i = 0, j = k - 1;
            //这里运用类似二分查找的思想(由于arr严格递增)
            while (i < j) {
                if (arr[i] + arr[j] == arr[k]) {
                    dp[j][k] = Math.max(dp[i][j], 3) + 1;
                    max = Math.max(max, dp[j][k]);
                    i++;
                    j--;
                } else if (arr[i] + arr[j] < arr[k])
                    i++;
                else
                    j--;
            }
        }
        return max;
    }


}
