package leetcode;

import java.util.Arrays;

public class Solution583 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=1;i<len1+1;i++){
            char word1_1 = word1.charAt(i-1);
            for(int j=1;j<len2+1;j++){
                char word2_1 = word2.charAt(j-1);
                if(word1_1==word2_1){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        for(int[] d:dp){
            System.out.println(Arrays.toString(d));
        }
        return len1+len2 - (dp[len1][len2]*2);
    }
}
