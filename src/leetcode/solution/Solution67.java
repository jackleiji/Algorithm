package leetcode.solution;

public class Solution67 {
    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }
    public static String addBinary(String a, String b) {
        StringBuilder a_re = new StringBuilder(a).reverse();
        StringBuilder b_re = new StringBuilder(b).reverse();

        StringBuilder res = new StringBuilder();
        int flag = 0;
        int lenA = a_re.length();
        int lenB = b_re.length();
        int index = 0;
        while (index<Math.min(lenA,lenB)){
            int a_c = a_re.charAt(index)-'0';
            int b_c = b_re.charAt(index)-'0';
            int sum = a_c+b_c+flag;
            flag=0;
            res.append(sum%2);
            if(sum>=2) flag=1;
            index++;
        }
        while (index<lenA){
            int a_c = a_re.charAt(index)-'0';
            int sum = a_c+flag;
            flag=0;
            res.append(sum%2);
            if(sum>=2) flag=1;
            index++;
        }
        while (index<lenB){
            int b_c = b_re.charAt(index)-'0';
            int sum = b_c+flag;
            flag=0;
            res.append(sum%2);
            if(sum>=2) flag=1;
            index++;
        }
        if(flag==1) res.append('1');
        return res.reverse().toString();
    }
}
