package leetcode;

public class Solution43 {
    public static void main(String[] args) {
        System.out.println(multiply("92","0"));
    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        int m = num1.length();
        int n = num2.length();
        int[] resArr = new int[m+n];
        for(int i = m-1;i >= 0; i--){
            for(int j = n-1; j >= 0;j--){
                int mul1 = num1.charAt(i)-'0';
                int mul2 = num2.charAt(j)-'0';
                resArr[i+j+1] += mul1*mul2;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i=resArr.length-1;i>0;i--){
            resArr[i-1] += resArr[i]/10;
            res.append(resArr[i]%10);
            if(i-1==0&& resArr[i-1]!=0) res.append(resArr[i-1]);
        }
        return res.reverse().toString();
    }
}
