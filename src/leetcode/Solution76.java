package leetcode;

public class Solution76 {
    public static void main(String[] args) {
        System.out.println(minWindow("z","z"));
        System.out.println((int)'z'-'A');
    }
    public static String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if(slen<tlen) return "";
        int[] arr_t = new int[58];
        int[] arr_s = new int[58];
        for(int i=0;i<tlen;i++){
            arr_t[t.charAt(i)-'A']++;
        }
        int left =0;
        int ansL= -1;int ansR=-1;
        int subLen = Integer.MAX_VALUE;
        for(int i=0;i<slen;i++){
            char s_letter = s.charAt(i);
            arr_s[s_letter-'A']++;
            while (check(arr_t,arr_s) && left<=i){
                if(i-left+1<subLen){
                    ansL = left;
                    ansR = i+1;
                    subLen = i-left+1;
                }
                arr_s[s.charAt(left)-'A']--;
                left++;
            }
        }
        System.out.println(ansL+" "+ansR);
        return ansL==-1?"":s.substring(ansL,ansR);
    }
    public static boolean check(int[] arr_t,int[] arr_s){
        for(int i=0;i<arr_t.length;i++){
            if(arr_s[i]<arr_t[i]){
                return false;
            }
        }
        return true;
    }
}
