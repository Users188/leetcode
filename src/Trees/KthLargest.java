package Trees;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * leetcode:数据流的第k大值
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 **/
public class KthLargest {
    /* 暴力解法
    int k;
    ArrayList<Integer> arrayList;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        arrayList = Arrays
                .stream(nums)
                .boxed().
                        collect(Collectors.toCollection((Supplier<ArrayList<Integer>>) ArrayList::new));
    }

    public int add(int val) {
        arrayList.add(val);
        arrayList.sort(Collections.reverseOrder());
        return arrayList.get(k-1);
    }*/
    //利用小根堆的特性（动态数据流常用方法）
    int k;
    PriorityQueue<Integer> heap;
    public KthLargest(int k, int[] nums){
        this.k = k;
        heap=Arrays
                .stream(nums).
                        boxed().
                        collect(Collectors.toCollection(PriorityQueue::new));
    }

    public int add(int val){
        heap.add(val);
        while (heap.size()>k)
            heap.poll();
        return heap.peek();
    }
}
