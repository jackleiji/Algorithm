package leetcode.solution;

import java.util.Arrays;

public class Solution66 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,0,9})));
    }
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int index = len-1;
        int carry = (digits[index]+1)/10;
        int numb = digits[index]+1;
        digits[index] = numb%10;
        index--;
        while (index>=0){
            numb = carry+digits[index];
            carry = numb/10;
            digits[index] = numb%10;
            if(carry==0) return digits;
            index--;
        }
        if(carry!=0){
            int[] res = new int[len+1];
            res[0] = 1;
            for(int i=1;i<=len;i++){
                res[i] = digits[i-1];
            }
            return res;
        }

        return digits;
    }
}
