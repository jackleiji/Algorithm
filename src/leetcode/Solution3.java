package leetcode;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        //思路：map存储字符数据，通过左右指针，左指针减，右指针加
        //定义flag，有重复flag=true，直到做指针遇到重复位flag=flag

        lengthOfLongestSubstring("pwwkew");

    }
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len==0) return 0;
        else if(len == 1) return 1;
        int l = 0;
        int r = 0;
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        while (r<len){
            Character temp = s.charAt(r);
            map.put(temp,map.getOrDefault(temp,0)+1);
            r++;
            //注意复制的是否修改了对象名，不够细心。
            while (map.get(temp)>1 && l<=r && l<len){
                Character lTemp = s.charAt(l);
                map.put(lTemp,map.getOrDefault(lTemp,0)-1);
                l++;
            }
            res = Math.max(res,r-l);
        }
        return res;
    }
}
