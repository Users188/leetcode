package HashMaps;
/*leetcode:插入、删除和随机访问都是 O(1) 的容器*/

/*保证插入删除为 O(1)使用hashmap，随机访问为 O(1)使用数组。*/
import java.util.*;

public class RandomizedSet {
    //key为集合中元素,value为该元素在列表中的下标
    Map<Integer,Integer> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }

    /** Inserts a value to the set.
     * Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    /** Removes a value from the set.
     * Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int last=list.get(list.size()-1);
        //将val移至列表末尾(待删除)
        list.set(map.get(val),last);
        //更新原last在map中的值
        map.put(last,map.get(val));
        //按索引删除操作时间复杂度为 O(1)
        list.remove(list.size()-1);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random r=new Random();
        int randomIndex=Math.abs(r.nextInt()%(list.size()));
        return list.get(randomIndex);
    }
}
