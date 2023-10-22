package leetcode.solution;

public class Solution5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
    public static String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        String res = s.substring(0,1);
        for(int i = 0;i< s.length();i++){
            //考虑中心为双数
            int left = i-1;
            int right = i+1;
            while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1>res.length()){
                res = s.substring(++left,right);
            }
            //中心为单个数
            left = i;
            right = i+1;
            while(left>=0&&right<s.length()&&s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1>res.length()){
                res = s.substring(++left,right);
            }
        }
        return res;
    }
}
