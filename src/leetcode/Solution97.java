package leetcode;

import java.util.Arrays;

public class Solution97 {
    public static void main(String[] args) {
        isInterleave("dbbca","aabcc","aadbbcbcac");
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        int len_s1 = s1.length();
        int len_s2=s2.length();
        int len = s3.length();
        if(len_s1+len_s2!=len) return false;
        boolean[][] flag = new boolean[len_s1+1][len_s2+1];
        flag[0][0] = true;
        for(int i=0;i<=len_s1;i++){
            for(int j=0;j<=len_s2;j++){
                int p = i+j-1;//记录s3的位置
                if(i>0){
                    flag[i][j] = flag[i][j] || (flag[i-1][j]&&s1.charAt(i-1)==s3.charAt(p));
                }
                if(j>0){
                    flag[i][j] = flag[i][j] || (flag[i][j-1]&&s2.charAt(j-1)==s3.charAt(p));
                }
            }
        }
        for(boolean[] f:flag){
            System.out.println(Arrays.toString(f));
        }
        return flag[len_s1][len_s2];
    }
}
