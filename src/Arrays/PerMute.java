package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode:没有重复元素集合的全排列
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class PerMute {
    List<List<Integer>> res;
    List<Integer> path;
    //使用一个set来存储已经访问过的num
    Set<Integer> visited;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>(nums.length);
        visited = new HashSet<>();
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        backtrack(nums,0, nums.length);
    }

    //获取nums[start,end)的全排列
   private void backtrack(int[] nums, int start, int end) {
        if (path.size() == end - start) {
            res.add(List.copyOf(path));
            return;
        }
        for (int i = start; i < end; i++) {
            if (!visited.contains(nums[i])) {
                path.add(nums[i]);
                visited.add(nums[i]);
                backtrack(nums, start, end);
                visited.remove(path.remove(path.size() - 1));
            }
        }
    }
}
