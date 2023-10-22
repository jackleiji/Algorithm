package leetcode;

import java.util.Arrays;

public class Solution72 {
    public static void main(String[] args) {
        System.out.println(minDistance("distance","springbok"));
    }
    public static int minDistance(String word1, String word2) {
//        int len1 =word1.length();
//        int len2 = word2.length();
//        int[][] dp = new int[len1+1][len2+1];
//
//        for(int i=1;i<len1+1;i++){
//            char word_1 = word1.charAt(i-1);
//            for(int j=1;j<len2+1;j++){
//                char word_2 = word2.charAt(j-1);
//                if(word_1==word_2){
//                    dp[i][j] = dp[i-1][j-1]+1;
//                    continue;
//                }
//                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//            }
//        }
//        for(int[] d : dp){
//            System.out.println(Arrays.toString(d));
//        }
//
//        return len1-dp[len1][len2];
        int len1 =word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        if(len1*len2==0) return len1+len2;
        for(int i=0;i< len1+1;i++){
            dp[i][0] = i;
        }
        for(int i=0;i< len2+1;i++){
            dp[0][i] = i;
        }

        for(int i=1;i<len1+1;i++){
            char temp1 = word1.charAt(i-1);
            for(int j=1;j<len2+1;j++){
                char temp2 = word2.charAt(j-1);
                //状态转移方程
                if(temp1==temp2){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
            }
        }
        for(int[] d:dp){
            System.out.println(Arrays.toString(d));
        }
        return dp[len1][len2];
    }
}
