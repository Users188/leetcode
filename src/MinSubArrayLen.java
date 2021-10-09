import java.util.Arrays;

/*leetcode:和大于等于target的最短子数组*/

/*给定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
并返回其长度。如果不存在符合条件的子数组，返回 0 。
*/
public class MinSubArrayLen {
    public int minSubArrayLen(int target,int[] nums){
        //滑动窗口
        int result = 0;
        int left=0,right=nums.length-1;
        while (left<right){
            int sum=0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
                if (sum>=target)
                    break;
            }
        }
        return result;
    }
}
