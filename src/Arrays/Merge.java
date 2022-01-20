package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * leetcode:合并区间
 * <p>
 * 以数组 intervals 表示若干个区间的集合，
 * 其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        TreeSet<Integer> bounds_Set = new TreeSet<>();
        HashMap<Integer, Integer> mapIntervals = new HashMap<>();
        for (int[] interval : intervals) {
            bounds_Set.add(interval[0]);
            bounds_Set.add(interval[1]);
            if (!mapIntervals.containsKey(interval[0]))
                mapIntervals.put(interval[0], interval[1]);
            else {
                int max = Math.max(interval[1], mapIntervals.get(interval[0]));
                mapIntervals.put(interval[0], max);
            }
        }
        //获得以边界值为元素升序排列的列表（无重复值）。类似数轴
        List<Integer> boundsList = new ArrayList<>(bounds_Set);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < boundsList.size(); ) {
            int left = boundsList.get(i);
            int right = mapIntervals.get(left);
            for (int j = i; j < boundsList.size(); j++) {
                //当前边界值
                int bound = boundsList.get(j);
                //如果(x,y)区间内有左边界值（最小值），则将y更新为较大的右边界值
                if (bound < right && mapIntervals.containsKey(bound)) {
                    right = Math.max(right, mapIntervals.get(bound));
                }
                //如果当前边界值等于当前区间右边界值
                if (bound == right) {
                    //如果当前边界值为右边界值（两种情况：不在左边界值中或左右边界值相等）
                    if (!mapIntervals.containsKey(bound) || mapIntervals.get(bound) == bound){
                        res.add(new int[]{left, right});
                        i = j + 1;
                        break;
                    }
                    else
                        right = mapIntervals.get(bound);
                }
            }
        }
        return res.toArray(new int[0][0]);
    }



}
