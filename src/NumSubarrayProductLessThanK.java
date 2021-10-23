/*leetcode 乘积小于k的子数组*/
/*给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。*/
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0, left = 0, right = 0;
        int total = 1;
        if (k <= 0)
            return result;
        while (right < nums.length) {
            total *= nums[right];
            //一旦窗口乘积大于k，使total变小——除去最左边的数
            while (left <= right && total >= k) {
                total /= nums[left++];
            }
            //当数组中某个数大于k时，left>right
            if (left <= right)
                //指针每移动一次，子数组数量增加（一个窗口长度+1）
                result += right - left + 1;
            right++;
        }
        return result;
    }
}
