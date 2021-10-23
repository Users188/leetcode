import java.util.HashMap;

/*leetcode:和为k的子数组*/
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        //前缀和方法
        //preSum[j]=preSum[i]-k
        int result = 0, preSum = 0;
        if (nums == null)
            return result;
        //hashmap存储所有的前缀和：即第0项到第i项的和。
        //key:preSum,value:preSum出现的次数
        HashMap<Integer, Integer> preSums = new HashMap<>();
        //前缀和利用的是从前计算过的结果，所以必然存在一个初始值
        //初始值，取k=num[0],则有k=preSum[i]-preSum[j]=preSum[0]-0,即必然存在preSum[j]=0
        preSums.put(0, 1);
        for (int num : nums) {
            preSum += num;
            result += preSums.getOrDefault(preSum - k, 0);
            preSums.put(preSum, preSums.getOrDefault(preSum, 0) + 1);
        }
        return result;
    }
}
