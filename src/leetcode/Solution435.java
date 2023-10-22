package leetcode;

import java.util.Arrays;

public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int res = 1;
        if(intervals.length == 0){
            return 0;
        }

        int len = intervals.length;
        int right = intervals[0][1];
        for(int i=1;i<len;i++){
            if(intervals[i][0]>=right){
                res++;
                right = intervals[i][1];
            }
        }
        return res;
    }
}
