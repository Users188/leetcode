package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode:所有子集
 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class SubSets {
    //二进制枚举
    public List<List<Integer>> subsets_1(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        //集合的子集总数为2^n,mask的二进制表示蕴含其集合元素的信息
        for (int mask = 0; mask < (1 << nums.length); mask++) {
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                //对于mask的二进制表示，mask & (1<<j) > 1表示其该位上为1，存在该元素。
                if ((mask & (1 << j)) > 0)
                    set.add(nums[j]);
            }
            subSets.add(set);
        }
        return subSets;
    }

    //回溯法
    public List<List<Integer>> subsets_2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(lists, list, nums, 0, nums.length);
        return lists;
    }

    //重要的是画出决策树
    private void backtrack(List<List<Integer>> lists, List<Integer> list,
                           int[] nums, int start, int length) {
        lists.add(new ArrayList<>(list));
        if (start >= length)
            return;
        for (int i = start; i < length; i++) {
            list.add(nums[i]);
            backtrack(lists, list, nums, i + 1, length);
            list.remove(list.size() - 1);
        }
    }

    //逐个枚举，空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，追加这个元素，就是新增的子集。
    public List<List<Integer>> subsets_3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }

}
