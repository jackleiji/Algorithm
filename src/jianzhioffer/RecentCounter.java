package jianzhioffer;

import java.util.*;

public class RecentCounter {
    //solution42
    LinkedList<Integer> list;
    public RecentCounter() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        int startTime = t-3000;
        if(startTime<1) {
            list.add(t);
            return list.size();
        }
        list.add(t);
        while (!list.isEmpty()){
            int temp = list.getFirst();
            System.out.println(temp);

            if(temp>=startTime){
                break;
            }
            list.remove(0);
        }
        System.out.println(list.toString());
        return list.size();
    }

}
