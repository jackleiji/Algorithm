package leetcode.solution;

import java.util.*;

public class Solution763 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("a").toString());
    }
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            char letter = s.charAt(i);
            end = Math.max(map.get(letter),end);
            if(end==i){
                res.add(end-start+1);
                start = end+1;
            }

        }
        return res;
    }
}
