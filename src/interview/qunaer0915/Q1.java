package interview.qunaer0915;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 最长公共子序列逆序输出
     * @param string1 string字符串
     * @param string2 string字符串
     * @return string字符串
     */
    public String maxSubsequenceAndReverse (String string1, String string2) {
        // write code here
        StringBuilder res = new StringBuilder();
        int len1 = string1.length();
        int len2 = string2.length();
//        for(int i=0;i<len1;i++){
//            char c = string1.charAt(i);
//            if(string2.contains(Character.toString(c))){
//                string2.substring(string2.indexOf(Character.toString(c)),len2);
//                res.append(c);
//            }
//        }
        if(len1>len2){
            res = new StringBuilder(string2);
            return res.reverse().toString();
        }else {
            res = new StringBuilder(string1);
            return res.reverse().toString();
        }
    }
}
