package Integers;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode:含有k个元素的组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 提示:
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(k);
        backtrack(res, list, 1, n, k);
        return res;
    }

    private void backtrack(List<List<Integer>> lists,
                           List<Integer> list, int start, int end, int size) {
        if (list.size() + (end - start + 1) < size)
            return;
        if (list.size() == size) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= end; i++) {
            list.add(i);
            backtrack(lists, list, i + 1, end, size);
            list.remove(list.size() - 1);
        }
    }
}
