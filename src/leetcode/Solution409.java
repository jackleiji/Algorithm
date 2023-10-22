package leetcode;

import java.util.*;

public class Solution409 {
    public int longestPalindrome(String s) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        for(char letter : str){
            map.put(letter,map.getOrDefault(letter,0)+1);
        }
        Set<Character> key = map.keySet();
        Iterator<Character> iterator = map.keySet().iterator();
        boolean flag = false;
        while (iterator.hasNext()){
            Character letter = iterator.next();
            int len_val = map.get(letter);

            if(len_val == 1){
                flag =true;
                continue;
            }else if(len_val%2==1){
                flag =true;
                res += len_val-1;
            }else if(len_val%2==0){
                res += len_val;
            }
        }
        return flag?res+1:res;
    }
}
