package Arrays;/*leetcode:三数之和为0*/

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //排序+双指针，思路延续twosum
        Arrays.sort(nums);
        //去重
        Set<List<Integer>> results = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int threesum = nums[left] + nums[right] + nums[i];
                if (threesum == 0) {
                    results.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                } else if (threesum < 0)
                    left++;
                else
                    right--;
            }
        }
        return new ArrayList<>(results);
    }

    public List<List<Integer>> threeSum_modified(int[] nums) {
        //不用set去重
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return results;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
//                if(nums[i]==nums[i+1]) continue;错误！
//                假设if为真，则num[i]不会被left纳入，会缺少类似（-1）+（-1）+2=0 的情况
            if (i > 0 && nums[i - 1] == nums[i]) continue;//去重
            int left = i + 1, right = nums.length - 1;
            //找出对应nums[left] + nums[right] + nums[i]==0的情况
            while (left < right) {
                int threesum = nums[left] + nums[right] + nums[i];
                if (threesum == 0) {
                    results.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                    //由于数组经过排序，所以相同的数会排列在一起，可以去重。
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                } else if (threesum < 0)
                    left++;
                else
                    right--;
            }
        }
        return results;
    }
}
