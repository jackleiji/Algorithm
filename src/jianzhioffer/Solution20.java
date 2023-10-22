package jianzhioffer;

public class Solution20 {
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;
        //双指针，中心向外扩展
        for(int i=0;i<2*len-1;i++){
            int left = i/2;
            int right = left+i%2;
            while (left>=0 && right<len-1 && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }
}
