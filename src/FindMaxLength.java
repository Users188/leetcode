/*leetcode:0 and 1个数相同的子数组*/

/*给定一个二进制数组 nums (num[i]只能为0或者1), 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
*/


import java.util.HashMap;

public class FindMaxLength {
    public int findMaxLength_wronged(int[] nums){
        //错误示范，无法使用滑动窗口，因为无法确定只移动左指针/右指针可以使窗口变大/变小
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

    public int findMaxLength_modified(int[] nums){
        //题意转化为：求子数组的和等于其长度的一半的最长子数组
        if (nums==null||nums.length<2)
            return 0;
        int maxlen=0;
        //暴力解法，leetcode超时
        for (int i=0;i<nums.length-2;i++){
            for (int j = i+1; j < nums.length-1; j++) {
                int len=j-i+1;
                if (len%2==0){
                    int subsum=0;
                    for (int m=i;m<=j;m++)
                        subsum+=nums[m];
                    if (subsum*2==len)
                        maxlen=Math.max(maxlen,len);
                }
            }
        }
        return maxlen;
    }

    public int findMaxLength(int[] nums){
        //前缀和
        //trick:将0全部转换为-1，则子数组和为0时0和1数量相等。简化计算
        //利用上述技巧，可以得preSum[j]-preSum[i]=0,即preSum[j]=preSum[i](i<j)
        if (nums==null||nums.length<2)
            return 0;
        HashMap<Integer,Integer> preSums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0)
                nums[i]=-1;
        }
        int maxlen=0,preSum=0;
        preSums.put(0,-1);
        for (int i=0;i<nums.length;i++){
            preSum+=nums[i];
            if (preSums.containsKey(preSum)){
                maxlen=Math.max(maxlen,i-preSums.get(preSum));
            }
            else
                preSums.put(preSum,i);
        }
        return maxlen;

    }
}
