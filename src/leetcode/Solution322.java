package leetcode;

import java.util.Arrays;

public class Solution322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2},3));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        for(int i=1;i<amount+1;i++){
            dp[i] = amount+1;
            for(int j=0;j<coins.length;j++){
                int rest = i-coins[j];
                if(rest>=0){
                    dp[i] = Math.min(dp[i],dp[rest]+1);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[amount]>amount?-1:dp[amount];
    }
}
