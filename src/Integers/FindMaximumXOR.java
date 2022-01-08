package Integers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode:最大的异或
 * 给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 10^4
 * 0 <= nums[i] <= 2^31 - 1
 */
public class FindMaximumXOR {

    public int findMaximumXOR_primitive(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            for (int num1 : nums) {
                max = Math.max(max, num ^ num1);
            }
        }
        return max;
    }

    public int findMaximumXOR_modified(int[] nums) {
        int max = 0;
        final int HIGH_BIT = 30;//0 <= nums[i] <= 2^31 - 1,即num最多有30位
        for (int i = HIGH_BIT; i >= 0; i--) {
            Set<Integer> bits = new HashSet<>();
            for (int num : nums)
                bits.add(num >> i);
            int maxNext = (max << 1) + 1;
            boolean found = false;
            for (int num : nums) {
                if (bits.contains(maxNext ^ (num >> i))) {
                    found = true;
                    break;
                }
            }
            if (found)
                max = maxNext;
            else
                max = maxNext - 1;
        }
        return max;
    }

    public int findMaximumXOR_ultimate(int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        //获得ans的二进制位数
        int depth = 31 - Integer.numberOfLeadingZeros(maxNum);
        Set<Integer> prefix = new HashSet<>();
        int max = 0;
        //由高位到低位逐位地确定ans在第i位是否有1
        for (int i = depth; i >= 0; i--) {
            max <<= 1;
            int max1 = max | 1;
            prefix.clear();
            for (int num : nums) {
                prefix.add(num >> i);
                //利用异或的性质：x=y^z,则y=x^z
                if (prefix.contains(num >> i ^ max1)) {
                    max = max1;
                    break;
                }
            }
        }
        return max;
    }
}
