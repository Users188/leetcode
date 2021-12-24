package HashMaps;

import java.util.*;

/** leetcode:出现频率最高的k个数字
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。*/
public class TopKFrequent {
    public int[] topKFrequent_primitive(int[] nums, int k) {
        HashMap<Integer,Integer> numsMap = new HashMap<>();
        for (int num: nums) {
            numsMap.put(num,numsMap.getOrDefault(num,0)+1);
        }
//        ArrayList<Integer> result = new ArrayList<>();
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int maxValue = 0,key = Integer.MAX_VALUE;
            for(Map.Entry<Integer,Integer> entry:numsMap.entrySet()){
                if (entry.getValue()>maxValue){
                    key = entry.getKey();
                    maxValue = entry.getValue();
                }
            }
            result[i] = key;
            numsMap.remove(key);
        }
//        return result.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    //大根堆
    public int[] topKFrequent_modified(int[] nums, int k){
        int[] result = new int[k];
        Arrays.sort(nums);
        PriorityQueue<int[]> kQueue = new PriorityQueue<>(k, Comparator.comparingInt((int[] o) -> o[1]).reversed());
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]){
                kQueue.offer(new int[]{num,count});
                num = nums[i];
                count = 1;
            }
            else
                count++;
        }
        //将最后一个重复的加入
        kQueue.offer(new int[]{num,count});
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(kQueue.poll())[0];
        }
        return result;
    }

    public int[] topKFrequent(int[] nums,int k){
        HashMap<Integer,Integer> numsMap = new HashMap<>();
        for (int num: nums) {
            numsMap.put(num,numsMap.getOrDefault(num,0)+1);
        }
        List<int[]> mapEntries = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry: numsMap.entrySet()
             ) {
            mapEntries.add(new int[]{entry.getKey(), entry.getValue()});
        }
        mapEntries.sort(Comparator.comparingInt((int[] o) -> o[1]).reversed());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = mapEntries.get(i)[0];
        }
        return result;
    }
}
