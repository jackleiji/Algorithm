package leetcode.solution;

import java.util.Arrays;

public class Solution221 {
    public static void main(String[] args) {

    }
    public int maximalSquare(char[][] matrix) {
        int n= matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        //动态规划。非边缘点的正方形个数和他的上、左、左上的最小值相关。
        //因此，判断当前位置是否是矩形以及大小时，可以根据最小值+1来解决
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0){
                    dp[i][j] = matrix[i][j]-'0';
                    System.out.println(matrix[i][j]);
                    continue;
                }
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }
                res = Math.max(dp[i][j],res);
            }
        }
        for(int[] i:dp){
            System.out.println(Arrays.toString(i));
        }
        return res;

    }
}
