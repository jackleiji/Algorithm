package leetcode;

import java.util.Arrays;

public class Solution279 {
    //动态规划。找到输入数据从1-n的平方和
    public int numSquares(int n) {
        int[] ans = new int[n+1];

        for(int i=1;i<n+1;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j*j<i;i++){
                min = Math.min(min,ans[i-j*j]);
            }
            ans[i] = 1+min;
        }
        System.out.println(Arrays.toString(ans));
        return ans[n];
    }
}
