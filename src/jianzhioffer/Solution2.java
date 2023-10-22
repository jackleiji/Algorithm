package jianzhioffer;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(addBinary("111","10"));
    }
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        // 法一：
//        int flag = 0;
//        StringBuilder s_long = new StringBuilder(a).reverse();
//        StringBuilder s_short = new StringBuilder(b).reverse();
//        if(a.length()<b.length()){
//            StringBuilder temp =  s_long;
//            s_long = s_short;
//            s_short = temp;
//        }
////        System.out.println(s_long+" "+s_short);
//        int len = Math.min(s_long.length(),s_short.length());
//        for(int i =0;i<len;i++){
//            int a_temp = s_long.charAt(i)-'0';
//            int b_temp = s_short.charAt(i)-'0';
//            int sum = a_temp+b_temp+flag;
////            System.out.println(a_temp+" "+b_temp);
//            flag=0;
//            res.append(sum%2);
//            if(sum>=2){
//                flag=1;
//            }
//            if (i+1==len){
//                for(int j = len;j<s_long.length();j++){
//                    int temp = s_long.charAt(j)-'0';
//                    int sum_left = temp+flag;
//                    flag=0;
//                    res.append(sum_left%2);
//                    if(sum_left>=2){
//                        flag=1;
//                    }
//                }
//            }
//        }
//        if(flag==1){
//            res.append(1);
//        }
//        return res.reverse().toString();
        //16F4
        String str = scanner.nextLine();
        System.out.println(Integer.parseInt(str,16));

        return res.toString();
    }
}
