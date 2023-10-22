package leetcode;

import java.util.*;

public class Solution187 {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA").toString());
    }
    public static List<String> findRepeatedDnaSequences(String s) {

        final List<String> res = new ArrayList<>();
        if(s.length()<10) return res;
        final  Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<s.length()-9;i++){
            String seq = s.substring(i,i+10);
//            System.out.println(seq);
            map.put(seq,map.getOrDefault(seq,0)+1);
        }
        for(String key:map.keySet()){
            if(map.get(key)>=2) res.add(key);
        }
        return res;
    }
}
