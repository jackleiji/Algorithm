package leetcode;

import java.util.*;

public class Solution56 {
    public static void main(String[] args) {

    }
    public int[][] merge(int[][] intervals) {
        //对二维数组排序
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(intervals,(e1,e2)->(e1[0]==e2[0]?(e1[1]-e2[1]):(e1[0]-e2[0])));
        for(int i=0;i<intervals.length-1;i++){
             if(intervals[i][1]<intervals[i+1][0]){
                 list.add(new int[]{intervals[i][0],intervals[i][1]});
             }else{
                 intervals[i+1][0] = Math.min(intervals[i][0],intervals[i+1][0]);
                 intervals[i+1][1] = Math.max(intervals[i][1],intervals[i+1][1]);
             }
        }
        list.add(new int[]{intervals[intervals.length-1][0],intervals[intervals.length-1][1]});
        //一维链表转为二维数组
        return list.toArray(new int[list.size()][]);
    }
}
