package leetcode.solution;

import java.util.*;

public class RandomizedSet {
    Set set = new HashSet();
    List<Integer> list = new LinkedList<>();
    Random random = new Random();
    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(set.add(val)){
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(set.remove(val)){
            System.out.println(list.indexOf(val));
            list.remove(list.get(val));
            return true;
        }
        return false;
    }

    public int getRandom() {
        int a = random.nextInt(set.size());
        System.out.println(list.toString());
        return list.get(a);
    }
}
