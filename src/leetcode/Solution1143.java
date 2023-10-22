package leetcode;

import java.util.Arrays;

public class Solution1143 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("hofubmnylkra","pqhgxgdofcvmr"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length(), n = text2.length();
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 1; i <= m; i++) {
//            char c1 = text1.charAt(i - 1);
//            for (int j = 1; j <= n; j++) {
//                char c2 = text2.charAt(j - 1);
//                if (c1 == c2) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[m][n];
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1+1][len2+1];
        for(int i=1;i<len1+1;i++){
            char test_1 = text1.charAt(i-1);
            for(int j=1;j<len2+1;j++){
                char test_2 = text2.charAt(j-1);
                if(test_1==test_2){
                    dp[i][j] = dp[i-1][j-1]+1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        for(int[] a:dp){
            System.out.println(Arrays.toString(a));
        }
        return dp[len1][len2];
    }
}
