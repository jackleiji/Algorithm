package leetcode;

import java.util.Arrays;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] arr = new int[len+1];
        //当前台阶为前一节或前2节台阶的最小花费
        arr[0] = cost[0];
        arr[1] = cost[1];
        for(int i=2;i<len;i++){
            int temp = Math.min(arr[i-1],arr[i-2])+cost[i];
            arr[i] += temp;
        }
        System.out.println(Arrays.toString(arr));
        return Math.min(arr[len-1],arr[len-2]);
    }
}
