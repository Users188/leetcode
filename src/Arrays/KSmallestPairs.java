package Arrays;

import java.util.*;

/**
 * leetcode:和最小的k个数对
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 * 提示：
 * 1 <= nums1.length, nums2.length <= 104
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1, nums2 均为升序排列
 * 1 <= k <= 1000
 */
public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> results = new ArrayList<>(k);
        //大根堆
        Queue<int[]> kQueue = new PriorityQueue<>(k,
                (o1, o2) -> o2[0] + o2[1] - (o1[0] + o1[1])
        );
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                int[] pair = new int[]{nums1[i], nums2[j]};
                if (kQueue.size() < k) {
                    kQueue.add(pair);
                    continue;
                }
                int pairSum = pair[0] + pair[1];
                int topK = kQueue.peek()[0] + kQueue.peek()[1];
                if (pairSum < topK) {
                    kQueue.remove();
                    kQueue.add(pair);
                }
            }
        }
        while (!kQueue.isEmpty()) {
            int[] result = kQueue.remove();
            results.add(Arrays.asList(result[0], result[1]));
        }
        return results;
    }

}
