package jianzhioffer;

import java.util.*;

public class Solution15 {
    public List<Integer> findAnagrams(String s, String p) {
        //s中包含p的无序字符---双指针
        List<Integer> res = new ArrayList<>();
        //1.构造2个26字母矩阵，一个存s中p长的字符，一个存p的字符
        int len1 = s.length();
        int len2 = p.length();
        if(len1<len2) return res;
        int[] letter1 = new int[26];
        int[] letter2 = new int[26];
        //2.写入字符矩阵
        for(int i=0;i<len2;i++){
            ++letter1[s.charAt(i)-'a'];
            ++letter2[p.charAt(i)-'a'];
        }
        if(Arrays.equals(letter1,letter2)){
            res.add(0);
        }
        //3.窗口后移
        for(int i=len2;i<len1;i++){
            ++letter1[s.charAt(i)-'a'];
            --letter1[s.charAt(i-len2)-'a'];
            if(Arrays.equals(letter1,letter2)){
                res.add(i-len2+1);
            }
        }
        return res;
    }
}
