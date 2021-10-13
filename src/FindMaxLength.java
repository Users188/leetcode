/*leetcode:0 and 1个数相同的子数组*/

/*给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
*/

public class FindMaxLength {
    public int findMaxLength_unfinish(int[] nums){
        //题意转化为：求子数组的和等于其长度的一半的最长子数组
        if (nums==null||nums.length<2)
            return 0;
        int left=0,right=nums.length-1;
        int count_1,maxlen,delete;
        do {
            maxlen=right-left+1;
            count_1=Util.array_sum(nums,left,right);
            if (count_1*2<maxlen)
                delete=0;
            else if (count_1*2>maxlen)
                delete=1;
            else
                return maxlen;
            if (nums[left]==delete)
                left++;
            else if (nums[right]==delete)
                right--;
        }while (left<right && count_1*2!=maxlen);

        return 0;
    }
}
