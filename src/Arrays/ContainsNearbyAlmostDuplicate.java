package Arrays;

import java.util.*;

/*leetcode: 值和下标之差都在给定的范围内*/
/*给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。

如果存在则返回 true，不存在返回 false。
*/
/*
0 <= nums.length <= 2 * 104
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 1^04
0 <= t <= 2^31 - 1
以下方法使用Long都是因为整型长度不够
*/
public class ContainsNearbyAlmostDuplicate {
    //暴力解法
    public boolean containsNearbyAlmostDuplicate_primitive(int[] nums, int k, int t) {
        for (int i = k; i < nums.length; i++) {
            for (int j = k + 1; j < k + i && j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t)
                    return true;
            }

        }
        return false;
    }

    //暴力解法增强版
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        int[][] nums_id = new int[len][2];
        for (int i = 0; i < len; i++) {
            nums_id[i] = new int[]{nums[i], i};
        }
        //按nums[i]的大小排序，即nums_id[][0]
        Arrays.sort(nums_id, Comparator.comparing(o -> o[0]));
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                //由于排序过后nums[i]在nums_id[][0]中是递增的，所以差值大于t时可以退出循环
                if ((long) nums_id[j][0] - nums_id[i][0] > t) {
                    break;
                }
                if (Math.abs(nums_id[j][1] - nums_id[i][1]) <= k) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean containsNearbyAlmostDuplicate_modified(int[] nums, int k, int t) {
        //使用有序集合TreeSet，TreeSet内部使用红黑树实现
        //Integer.MINVALUE<=nums[i]<=Integer.MAXVALUE，在进行计算的过程中会超出整型范围,故使用Long
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //限定差值小于等于t |num[i]-ceiling|<=t
            Long ceiling = treeSet.ceiling((long) nums[i] - t);
            if (ceiling != null && ceiling <= (long) nums[i] + t)
                return true;
            treeSet.add((long) nums[i]);
            //将TreeSet作为滑动窗口，窗口大小为k。此处保证窗口大小不变，更新窗口的值。
            //限定下标差小于等于k
            if (i >= k)
                treeSet.remove((long) nums[i - k]);
        }
        return false;
    }

    //使用桶排序的思想
    public boolean containsNearbyAlmostDuplicate_ultimate(int[] nums, int k, int t) {
        //key:桶的id，value:num[i],设桶的大小为t+1
        //e.g.:[0,t]的数字放到桶0中,[t+1,2t+1]的数字放到桶1中,
        // 差值小于t的数可能出现在相邻桶，必然出现在同一桶（故每一个桶至多存放一个数字）
        // num[i]=(t+1)*id+b(0<=b<=t);
        Map<Long, Long> buckets = new HashMap<>();
        long bucketSize = t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getBucketId(nums[i], bucketSize);
            if (buckets.containsKey(id))
                return true;
            if (buckets.containsKey(id + 1) && buckets.get(id + 1) - nums[i] <= t)
                return true;
            if (buckets.containsKey(id - 1) && nums[i] - buckets.get(id - 1) <= t)
                return true;
            buckets.put(id, (long) nums[i]);
            //保证下标差小于等于k
            if (i >= k)
                buckets.remove(getBucketId(nums[i - k], bucketSize));
        }
        return false;
    }

    //获取桶id
    private long getBucketId(long num, long bucketSize) {
        //注意正负数的区别，要保证负数桶的大小也是t+1
        return num >= 0 ? num / bucketSize : (num + 1) / bucketSize - 1;
    }

}
