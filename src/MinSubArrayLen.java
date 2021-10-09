import java.util.Arrays;

/*leetcode:和大于等于target的最短子数组*/

/*给定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
并返回其长度。如果不存在符合条件的子数组，返回 0 。
*/
public class MinSubArrayLen {
    public int minSubArrayLen(int target,int[] nums){
        //滑动窗口
        /*窗口的大小需要根据题目条件进行调整
        最大连续...尽量扩张右边界，直到不满足题意再收缩左边界
        最小连续...尽量缩小左边界，直到不满足题意再扩大右边界*/
        int left=0,right=0,sum=0,result=Integer.MAX_VALUE;
        while (right<nums.length){
            sum+=nums[right];
            while (sum>=target){
                result = Math.min(result,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return result>nums.length?0:result;
    }
}
