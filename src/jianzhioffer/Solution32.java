package jianzhioffer;

import java.util.*;

public class Solution32 {
    public boolean isAnagram(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(lenS!=lenT) return false;
        Map<Character,Integer> mapS = new HashMap<>();
        int flag = 0;
        for(int i=0;i<lenS;i++){
            char le = s.charAt(i);
            char leT = t.charAt(i);
            mapS.put(le,mapS.getOrDefault(le,0)+1);
            if(le==leT) flag+=1;
        }
        if(flag==lenS) return false;
        for(int i=0;i<lenT;i++){
            char le = t.charAt(i);
            if(!mapS.containsKey(le))
                return false;
            mapS.put(le,mapS.getOrDefault(le,0)-1);
            if(mapS.get(le)<0) return false;
        }
        return true;
    }
}
