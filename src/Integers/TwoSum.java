package Integers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*leetcode:两数之和*/
public class TwoSum {
    /*暴力破解方法*/
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[0];
    }

    /*hashmap辅助，解决重复值，利用哈希查找*/
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
//        return new int[0];
    }

    /*排序+双指针*/
    public int[] twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            //sum每次需要更新
            int sum = nums[left] + nums[right];
            if (sum == target)
                return new int[]{left, right};
            else if (sum < target)
                left++;
            else right--;
        }
        return new int[2];
    }

}
