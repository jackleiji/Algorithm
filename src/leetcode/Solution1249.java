package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution1249 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("a)b(c))())(()d"));
    }
    public static String minRemoveToMakeValid(String s) {
        int len = s.length();
        int left_kuo_end = 0;
        int right_kuo_end = s.length()-1;
        int count_sign = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<len;i++){
            char sign = s.charAt(i);
            if(count_sign == 0 && sign==')'){
                set.add(i);
            }else if(sign=='('){
                left_kuo_end=i;
                count_sign++;
            }else if(sign==')'){
                right_kuo_end = i;
                count_sign--;
            }
        }
        System.out.println(count_sign);
        while (count_sign!=0){
            if(count_sign<0){
                char sign = s.charAt(right_kuo_end);
                if(sign == ')') {
                    set.add(right_kuo_end);
                    count_sign++;
                }
                right_kuo_end--;
            }else if(count_sign>0){
                char sign = s.charAt(left_kuo_end);
                if(sign == '(') {
                    set.add(left_kuo_end);
                    count_sign--;
                }
                left_kuo_end--;
            }
        }
        StringBuilder res = new StringBuilder();
        System.out.println(set.toString());
        for(int i=0;i<len;i++){
            if(set.contains(i)){
                continue;
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
