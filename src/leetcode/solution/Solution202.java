package leetcode.solution;

import java.util.*;

public class Solution202 {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
    public static boolean isHappy(int n) {
        int res = n;
        Set<Integer> s = new HashSet<>();
        s.add(res);
        while (res != 1){
            int temp = res;
            res=0;
            while (temp!=0){
                res += (temp%10)*(temp%10);
                temp /=10;
            }
            // System.out.println(res);
            if(s.contains(res)) return false;
            s.add(res);
        }
        return true;
    }
}
