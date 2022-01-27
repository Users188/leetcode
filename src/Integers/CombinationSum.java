package Integers;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode:允许重复选择元素的组合
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，
 * 找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class CombinationSum {
    private List<List<Integer>> res;
    private List<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(List.copyOf(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                backtrack(candidates, i, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }

    private void test(int[] candidates, int start, int target) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(List.copyOf(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            //将start换为i结果为原答案（组合），使用start则结果为和为target的排列
            test(candidates, start, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
