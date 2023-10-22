package jianzhioffer;

import java.util.*;

public class LRUCache {
    Map<Integer,Integer> map;
    int cap;
    public LRUCache(int capacity) {
        cap= capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int tempValue = map.get(key);
        put(key,tempValue);
        return tempValue;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }
        if(map.size()<cap){
            map.put(key,value);
            return;
        }
        int temp = cap;
        Map.Entry<Integer,Integer> entry = map.entrySet().iterator().next();
        map.remove(entry.getKey());
        map.put(key,value);

    }
}
