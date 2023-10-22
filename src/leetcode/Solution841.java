package leetcode;

import java.util.*;

public class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();//room size
        boolean[] flag = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;
        while (!queue.isEmpty()){
            int site = queue.poll();
            if(!flag[site]){
                flag[site] = true;
                count++;
                List<Integer> room_keys = rooms.get(site);
                for(int i=0;i<room_keys.size();i++){
                    int key = room_keys.get(i);
                    if(!flag[key]){
                        queue.add(key);
                    }
                }
            }
        }
        return count==n;
    }
}
