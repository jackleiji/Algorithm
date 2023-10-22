package jianzhioffer;

import java.util.Arrays;

public class Solution14 {
    public boolean checkInclusion(String s1, String s2) {
        //s2是否包含s1
//        int len1 = s1.length();
//        int len2 = s2.length();
//        int[] letter = new int[26];
//        for(int i=0;i<s1.length();i++){
//            letter[s1.charAt(i)-'a']++;
//        }
//        int[] letter_copy = Arrays.copyOf(letter,26);
//
//        for(int i=0;i<len2;i++){
//           for(int j=0;j<len1;j++){
//               int temp_i = i+j;
//               //获取字符
//               if(temp_i>=len2) break;
//               int temp_letter = s2.charAt(temp_i)-'a';
//               if(letter_copy[temp_letter]!=0){
//                   letter_copy[temp_letter]--;
//                    if(is_empty(letter_copy)) return true;
//               }
//               if(letter[temp_letter]==0) i=temp_i;
//           }
//           letter_copy = Arrays.copyOf(letter,26);
//           if(i+s1.length()>s2.length())break;
//        }
//        return false;
        //法二：滑动窗口
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1>len2) return false;
        int[] letter1 = new int[26];
        int[] letter2 = new int[26];
        for(int i=0;i<len1;i++){
            int temp1 = s1.charAt(i)-'a';
            int temp2 = s2.charAt(i)-'a';
            ++letter1[temp1];
            ++letter2[temp2];
        }
        if(Arrays.equals(letter1,letter2)) return true;
        for(int i=len1;i<len2;i++){
            ++letter2[s2.charAt(i)-'a'];
            --letter2[s2.charAt(i-len1)-'a'];
            if(Arrays.equals(letter1,letter2)) return true;
        }
        return false;
    }
    public boolean is_empty(int[] letter){
        for(int i=0;i<letter.length;i++){
            if(letter[i]!=0) return false;
        }
        return true;
    }
}
