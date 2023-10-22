package leetcode.solution;

import java.util.*;

public class Solution131 {
    static boolean[][] f;
    static List<List<String>> ret = new ArrayList<>();
    static List<String> ans = new ArrayList<>();
    static int n;

    public static void main(String[] args) {
        partition("aacdbaa");

    }
    public static List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for(int i=0;i<n;++i){
            Arrays.fill(f[i],true);
        }
        //预处理判断子串是否是回文
        //由尾部向前，动态规划判断是否是回文子串，公式：
        //s.charAt(i)==s.charAt(j))&&f[i+1][j-1]
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                f[i][j] = (s.charAt(i)==s.charAt(j))&&f[i+1][j-1];
            }
//            System.out.println(i);
//            System.out.println(Arrays.toString(f[i]));
        }
        for(boolean[] f1: f){
            System.out.println(Arrays.toString(f1));
        }
//        dfs(s,0);
        System.out.println(ret.toString());
        return ret;
    }
}
