package jianzhioffer;

import java.util.Arrays;
import java.util.*;

public class Solution17 {
    public static void main(String[] args) {

    }

    Map<Character,Integer> origin = new HashMap<>();
    Map<Character,Integer> compare = new HashMap<>();
    public String minWindow(String s, String t) {
        int len_t = t.length();
        for(int i=0;i<len_t;i++){
            char le = t.charAt(i);
            origin.put(le,origin.getOrDefault(le,0)+1);
        }
        int l = 0,r = -1;
        int len = Integer.MAX_VALUE;
        int ansL= -1,ansR=-1;
        int len_s = s.length();
        while (r<len_s){
            ++r;
            if(r<len_s && origin.containsKey(s.charAt(r))){
                compare.put(s.charAt(r),compare.getOrDefault(s.charAt(r),0)+1);
            }
            while (check()&&l<=r){
                if(r-l+1<len){
                    ansL=l;
                    ansR=r+1;
                    len = r-l+1;
                }
                //移除
                if(origin.containsKey(s.charAt(l))){
                    compare.put(s.charAt(l),compare.getOrDefault(s.charAt(l),0)-1);
                }
                l++;
            }
        }
        return ansL==-1?"":s.substring(ansL,ansR);
    }

    public boolean check(){
        Iterator iter=origin.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry map = (Map.Entry)iter.next();
            Character key = (Character)map.getKey();
            Integer val = (Integer)map.getValue();
            if(compare.getOrDefault(key,0)<val){
                return false;
            }
        }
        return true;
    }

//    public static String minWindow(String s, String t) {
//        String sb = "";
//        if(t.length()>s.length()) return "";
//        //遍历s串判断是否存在包含t的子串，
//        //记录t串中字符在s中的位置
//        int[] arr = new int[52];
//        int len_t = t.length();
//        int len_s = s.length();
//        for(int i=0;i<len_t;i++){
//            char letter = t.charAt(i);
//            if(letter>='a'){
//                arr[letter-'a'+26]++;
//                continue;
//            }else {
//                arr[letter - 'A']++;
//            }
//        }
//        for(int i = 0;i<s.length();i++){
//            int[] arr_copy = Arrays.copyOf(arr,52);
//            int len_temp = len_t;
//            List<Integer> list = new ArrayList();
//            for(int j=i;j<s.length();j++){
//                char letter = s.charAt(j);
//                if(len_temp==0) break;
//                if(letter>='a'){
//                    if(arr_copy[letter-'a'+26]>=1){
//                        list.add(j);
//                        arr_copy[letter-'a'+26]--;
//                        len_temp--;
//                    }
//                    continue;
//                }else {
//                    if(arr_copy[letter - 'A']>=1){
//                        list.add(j);
//                        arr_copy[letter - 'A']--;
//                        len_temp--;
//                    }
//                }
//            }
//            if(len_temp==0){
//                String sb1 = s.substring(list.get(0),list.get(len_t-1)+1);
//                if(sb=="") sb=sb1;
//                else if(sb.length()>sb1.length()) sb=sb1;
//            }else if(sb.length()==len_t || len_temp!=0) {
//                return sb;
//            }
//            System.out.println(sb);
//        }
//        return sb;
//    }
}
