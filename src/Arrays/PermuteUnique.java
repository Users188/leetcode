package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * leetcode:含有重复元素的全排列
 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * */
public class PermuteUnique {
    List<List<Integer>> res;
    List<Integer> path;
    //用于记录相对应的num是否被访问/选择过
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        visited = new boolean[nums.length];
        //排序使相等的数相邻
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        backtrack(nums, 0, nums.length);
    }

    private void backtrack(int[] nums, int start, int end) {
        if (path.size() == end - start) {
            res.add(List.copyOf(path));
            return;
        }
        //用于记录上一个选择的数。（第一次指定nums中肯定不会出现的数字 nums[i]>=-10）
        int lastNum = -11;
        for (int i = start; i < end; i++) {
            //如果该数没有被访问过并且与上一个数不一致
            if (!visited[i] && lastNum != nums[i]) {
                path.add(nums[i]);
                visited[i] = true;
                backtrack(nums, start, end);
                visited[i] = false;
                lastNum = nums[i];
                path.remove(path.size() - 1);
            }
        }
    }
}
