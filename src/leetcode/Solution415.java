package leetcode;

public class Solution415 {
    public static void main(String[] args) {
        System.out.println(addStrings("111","9"));
    }
    public static String addStrings(String num1, String num2) {
        //法一：
//        StringBuffer res = new StringBuffer();
//        StringBuffer numb1_ver = new StringBuffer();
//        StringBuffer numb2_ver = new StringBuffer();
//        numb1_ver.append(num1);
//        numb2_ver.append(num2);
//        numb1_ver.reverse();
//        numb2_ver.reverse();
//
//        char[] num1_char = numb1_ver.toString().toCharArray();
//        char[] num2_char = numb2_ver.toString().toCharArray();
//        int add_flag= 0;
//        int len = num1.length()<num2.length()?num1.length():num2.length();
//        for(int i=0;i<len;i++){
//            int numb1 = Integer.parseInt(Character.toString(num1_char[i]));
//            int numb2 = Integer.parseInt(Character.toString(num2_char[i]));
//            int sum = numb1 + numb2 + add_flag;
//            res.append(sum % 10);
//            add_flag = sum / 10;
//        }
//        if(num1.length()==num2.length()&&add_flag!=0){
//            res.append(add_flag);
//            return res.reverse().toString();
//        }else if(num1.length()>num2.length()){
//            for(int i=len;i<num1.length();i++){
//                int numb1 = Integer.parseInt(Character.toString(num1_char[i]));
//                numb1 += add_flag;
//                res.append(numb1 % 10);
//                add_flag = numb1 / 10;
//
//            }
//        }else if(num1.length()<num2.length()){
//            for(int i=len;i<num2.length();i++){
//                int numb2 = Integer.parseInt(Character.toString(num2_char[i]));
//                numb2 += add_flag;
//                res.append(numb2 % 10);
//                add_flag = numb2 / 10;
//            }
//        }
//        if(add_flag!=0)
//            res.append(add_flag);
//        return res.reverse().toString();
        //长短字符串
        String longNumb = num1.length()>=num2.length()?num1:num2;
        String shortNumb = num1.length()>=num2.length()?num2:num1;

        int indexlong = longNumb.length()-1;
        int indexshort = shortNumb.length()-1;
        StringBuilder res = new StringBuilder();
        int jiewei = 0;

        while (indexlong>=0||jiewei!=0){
            if(indexlong>=0) jiewei += longNumb.charAt(indexlong--)-'0';
            if(indexshort>=0) jiewei += shortNumb.charAt(indexshort--) - '0';

            res.append(jiewei%10);
            jiewei /=10;
        }
        return res.reverse().toString();
    }
}
