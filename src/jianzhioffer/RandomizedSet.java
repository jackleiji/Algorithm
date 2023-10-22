package jianzhioffer;

import java.util.*;

public class RandomizedSet {
    Set<Integer> set = new HashSet<>();
    List<Integer> nums;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val)) return false;
        set.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!set.contains(val)) return false;
        set.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int site = (int)Math.random()*set.size();
        System.out.println(site);
        Iterator iter = set.iterator();
        int removeNumb = 0;
        while (iter.hasNext()){
            Integer numb = (Integer) iter.next();
            removeNumb = numb;
            site--;
            if(site==-1) break;
        }
        remove(removeNumb);
        return removeNumb;
    }
}
