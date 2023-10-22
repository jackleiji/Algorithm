package leetcode;

import java.util.*;

public class Solution438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("ab","ab"));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if(p.length()>s.length()) return res;
        int len_s = s.length();
        int len_p = p.length();
        Map<Character,Integer> map_p = new HashMap<>();
        for(int i=0;i<len_p;i++){
            Character c = p.charAt(i);
            map_p.put(c,map_p.getOrDefault(c,0)+1);
        }
        //滑动窗口
        for (int i=0;i<len_s-len_p+1;i++){
            Map<Character,Integer> map_win = new HashMap<>();
            for(int j = i;j<i+len_p;j++){
                Character c = s.charAt(j);
                //剪枝
                if(!map_p.containsKey(c)){
                    i = j;
                    break;
                }
                map_win.put(c,map_win.getOrDefault(c,0)+1);
            }
//            System.out.println(map_win.toString());
            if(map_win.size() == map_p.size()){
                Iterator<Map.Entry<Character,Integer>> iterator = map_p.entrySet().iterator();
                boolean flag = true;
                while (iterator.hasNext()){
                    Map.Entry obj = iterator.next();
                    if(obj.getValue().equals(map_win.get(obj.getKey()))){
                        System.out.println(obj.getValue()+" "+map_win.get(obj.getKey()));
                        flag=false;
                        continue;
                    }
                }
                if(flag) res.add(i);
            }
//            System.out.println(i);
        }
        return res;
    }
}
