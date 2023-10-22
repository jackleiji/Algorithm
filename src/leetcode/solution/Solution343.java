package leetcode.solution;

import java.util.Arrays;

public class Solution343 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        for(int i=2;i<=n;i++){
            int curMax = 0;
            for(int j=1;j<i;j++){
                curMax = Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i] =curMax;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
