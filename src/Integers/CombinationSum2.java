package Integers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * leetcode:含有重复元素的集合
 * 给定一个可能有重复数字的整数数组candidates和一个目标数target，
 * 找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 * <p>
 * 提示:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSum2 {
    List<List<Integer>> res;
    List<Integer> path;
    int sum;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.path = new ArrayList<>();
        this.sum = 0;
        this.target = target;
        //将candidates排序以便于在回溯中避免重复
        Arrays.sort(candidates);
        backtrack(candidates, 0);
        return res;
    }

    private void backtrack(int[] candidate, int start) {
        if (sum == target) {
            res.add(List.copyOf(path));
            return;
        }
        //剪枝：对当前节点的所有子树进行有条件的选取
        for (int i = start; i < candidate.length; i++) {
            if (sum + candidate[i] > target)
                break;
            if (i > start && candidate[i] == candidate[i - 1])
                continue;
            path.add(candidate[i]);
            sum += candidate[i];
            backtrack(candidate, start);
            sum -= path.remove(path.size() - 1);
        }
    }

    private void test(int[] candidates, int start) {
        if (sum > target)
            return;
        if (sum == target && !containsDuplicate(res, path)) {
            res.add(List.copyOf(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i + 1);
            sum -= path.remove(path.size() - 1);
        }
    }

    private boolean containsDuplicate(List<List<Integer>> lists, List<Integer> list) {
        if (lists.isEmpty())
            return false;
        list = new ArrayList<>(list);
        Collections.sort(list);
        for (List<Integer> origin : lists) {
            if (origin.size() != list.size())
                continue;
            origin = new ArrayList<>(origin);
            Collections.sort(origin);
            if (origin.equals(list))
                return true;
        }
        return false;
    }
}
