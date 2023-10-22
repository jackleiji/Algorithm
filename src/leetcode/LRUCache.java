package leetcode;

import java.util.*;

public class LRUCache {
    int cap;
    Map<Integer,Integer> map;
    int index = 0;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key))return -1;
        int value = map.get(key);
        put(key,value);
        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }
        if(map.size()<cap){
            map.put(key,value);
            index++;
            return;
        }
        map.remove(map.keySet().iterator().next());
//        showMap(map);
        map.put(key,value);
    }
    public void showMap(Map<Integer,Integer> map){
        Iterator<Map.Entry<Integer, Integer>> entry = map.entrySet().stream().iterator();
        while (entry.hasNext()){
            Map.Entry<Integer, Integer> e= entry.next();
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }
}
