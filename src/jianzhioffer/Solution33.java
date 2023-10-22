package jianzhioffer;

import java.util.*;

public class Solution33 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        List<List<String>> res = new ArrayList<>();
        if(len==0) return res;
        else if(len==1){
            List<String> data = new ArrayList<>();
            data.add(strs[0]);
            res.add(data);
            return res;
        }
        String[] strEncode = new String[len];
        for(int i=0;i<len;i++){
            String word = strs[i];
            int[] arr =new int[26];
            for(int j=0;j<word.length();j++){
                arr[word.charAt(j)-'a']++;
            }
            strEncode[i] = Arrays.toString(arr);
        }
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<len;i++){
            String encode = strEncode[i];
            List<String> data = new ArrayList<>();
            if(map.containsKey(encode)){
                data = map.get(encode);
            }
            data.add(strs[i]);
            map.put(encode,data);
        }
        Iterator<List<String>> iterator = map.values().iterator();
        while (iterator.hasNext()){
            res.add(iterator.next());
        }
        return res;
    }
}
