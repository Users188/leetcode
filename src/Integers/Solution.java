package Integers;

import java.util.Arrays;
import java.util.Random;

/**
 * leetcode:按权重生成随机数
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），
 * 请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 * <p>
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），
 * 而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 * <p>
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 * <p>
 * 提示：
 * <p>
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex 将被调用不超过 10000 次
 */
public class Solution {
    Random random;
    int[] w;
    int[] preSum_w;
    int sum;

    public Solution(int[] w) {
        random = new Random();
        this.w = w;
        preSum_w = new int[w.length];
        int preSum = 0;
        for (int i = 0; i < w.length; i++) {
            preSum += w[i];
            preSum_w[i] = preSum;
        }
        sum = preSum;
    }

    public int pickIndex_primitive() {
        int r = random.nextInt(sum);
        int i;
        for (i = 0; i < w.length; i++) {
            r -= w[i];
            if (r < 0)//r不能取0
                return i;
        }
        return i - 1;
    }

    public int pickIndex() {
        int r = random.nextInt(sum);

        int index = Arrays.binarySearch(preSum_w, r);
        return index >= 0 ? index + 1: -index - 1;
    }
}
