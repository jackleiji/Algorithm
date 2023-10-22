package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abb","do do do"));
    }
    private static boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();

        char[] arr = pattern.toCharArray();
        String[] subArr = s.split(" ");

        if(arr.length!=subArr.length) return false;
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i]) && !map2.containsKey(subArr[i])){
                map.put(arr[i],subArr[i]);
                map2.put(subArr[i],arr[i]);
            }else {
                if(!map.getOrDefault(arr[i],"error").equals(subArr[i]) || !map2.getOrDefault(subArr[i],'0').equals(arr[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
