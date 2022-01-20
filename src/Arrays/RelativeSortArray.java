package Arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * leetcode:数组相对排序
 * 给定两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，
 * 使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。*/
public class RelativeSortArray {
    public int[] relativeSortArray_primitive(int[] arr1, int[] arr2) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : arr1) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        List<Integer> sortedArray = new ArrayList<>();
        for (int k : arr2) {
            for (int j = 0; j < frequency.get(k); j++) {
                sortedArray.add(k);
            }
            frequency.remove(k);
        }
        List<Integer> remains = new ArrayList<>();
        for (int key : frequency.keySet()) {
            for (int i = 0; i < frequency.get(key); i++) {
                remains.add(key);
            }
        }
        Collections.sort(remains);
        sortedArray.addAll(remains);
        return sortedArray.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = Arrays.stream(arr1).max().getAsInt();
        int[] frequency = new int[upper + 1];//统计arr1中的各个数出现次数，并对其升序排序（数组下标）
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }
}
