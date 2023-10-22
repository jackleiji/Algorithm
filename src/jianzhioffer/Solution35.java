package jianzhioffer;

import java.util.*;

public class Solution35 {
    int[] timeArr;

    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int res = Integer.MAX_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            String timeP = timePoints.get(i);
            String[] t = timeP.split(":");
            int timeInt = Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);

            if(queue.contains(timeInt)) return 0;
            queue.add(timeInt);
            min = Math.min(min,timeInt);
            max = Math.max(max,timeInt);
        }
        queue.add(-1);
        res = Math.min(max-min,1440-max+min);
        while (!queue.isEmpty()){
            int timeInt = queue.poll();
//            System.out.println(timeInt);
            if(timeInt==-1) break;
            int next = queue.peek();
            res = Math.max(res,timeInt-next);
        }
        return res;
    }
    public boolean timeToStr(String time){


        return true;
    }
}
