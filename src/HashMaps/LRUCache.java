package HashMaps;
/*leetcode:最近最少使用缓存*/
import java.util.LinkedHashMap;
import java.util.Map;

/*参考LinkedHashMap说明
* hashmap用于存储键值对，双向链表用于维护插入顺序*/
public class LRUCache {
    private Map<Integer,Integer> cache;

    public LRUCache(int capacity) {
        //把accessOrder设为true,默认为insertOrder
        cache=new LinkedHashMap<>(capacity,0.9f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size()>capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        cache.put(key,value);
    }
}
