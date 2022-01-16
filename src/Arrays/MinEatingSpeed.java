package Arrays;

import java.util.Arrays;

/**
 * leetcode:狒狒吃香蕉
 * <p>
 * 狒狒喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 狒狒可以决定她吃香蕉的速度 K （单位：根/小时）。
 * 每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，
 * 然后这一小时内不会再吃更多的香蕉，下一个小时才会开始吃另一堆的香蕉。
 * 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 */
public class MinEatingSpeed {

    //超时
    public int minEatingSpeed_primitive(int[] piles, int h) {
        int k = Arrays.stream(piles).max().getAsInt();//最大值
        int limit = Arrays.stream(piles).sum() / h;//最小值
        while (k-- >= limit) {
            int hours = getHours(piles, k);
            if (hours > h)
                break;
        }
        return k + 1;
    }

    //思路：二分搜索。寻找目标值的左侧边界值（目标值有重复）
    //题目转化：设数组hour[kMax-kMin+1],k为下标，hours为数组的值，数组为降序排序(hours += (pile - 1)/k + 1; hours与k成反比)。
    //则目标k值为最大的hour[k]<h。注意：k有重复值
    public int minEatingSpeed(int[] piles, int h) {
        int kMax = Arrays.stream(piles).max().getAsInt();
        int kMin = (Arrays.stream(piles).sum() - 1) / h + 1;
        while (kMin < kMax) {
            //防止整型溢出
            int k = kMin + ((kMax - kMin) >>> 1);
            int hours = getHours(piles, k);
            if (hours > h)
                kMin = k + 1;
            else
                kMax = k;
        }
        return kMax;
    }

    private int getHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile - 1) / k + 1;
        }
        return hours;
    }
}
