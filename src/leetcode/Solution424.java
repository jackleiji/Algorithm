package leetcode;

public class Solution424 {
    public static void main(String[] args) {

    }
    public int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;
        int maxlen = 0;
        int len = s.length();
        if(len<2) return len;
        int res = 0;
        int[] arr = new int[26];

        while (right<len){
            arr[s.charAt(right)-'A'] ++;
            maxlen = Math.max(maxlen,arr[s.charAt(right)-'A']);
            right++;
            if(right-left>maxlen +k){
                arr[s.charAt(right)-'A'] -- ;
                left++;
            }
            res = Math.max(res,right-left);

        }
        return res;
    }
}
