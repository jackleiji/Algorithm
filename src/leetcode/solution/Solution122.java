package leetcode.solution;

import java.util.Arrays;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2) return 0;
        //0:买入
        //1：（持有现金）卖出
        int[][] flag = new int[len][2];
        flag[0][0] = -prices[0];//买入为负值
        flag[0][1] = 0;//不买入
        //状态转移
        for(int i=1;i<len;i++){
            flag[i][0] = Math.max(flag[i-1][0],flag[i-1][1]-prices[i]);
            flag[i][1] = Math.max(flag[i-1][1],flag[i-1][0]+prices[i]);
        }
        //打印转印表
        for(int[] arr : flag){
            System.out.println(Arrays.toString(arr));
        }
        //放回最终持有现金的值
        return flag[len-1][1];
    }
}
