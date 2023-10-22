package leetcode.meituan.t0422;
import java.util.*;
public class Q4 {
//    小美给你一个长度为n 的01串（仅包含字符0和1的串），你可以删除这个串的一个前缀和一个后缀(可以为空) ,
//    即保留一个原串的连续子串,操作之后整个串的代价为下面两部分之和：
//     1.被到脸的字符1的个数
//    2.剩下的子串的字符0的个数
//    你需要最小化操作的代价，并将其输出。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(Cost(str));
    }
    public static int Cost(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        int res = 0;
        while (left<right){
            char l=s.charAt(left);
            char r=s.charAt(right);
            while (r=='0') {
                right--;
                r=s.charAt(right);
            }
            while (l=='0'){
                left++;
                l=s.charAt(left);
            }
            if(l=='1'&&r=='1'){
                left++;
                right--;
                r=s.charAt(right);
                l=s.charAt(left);
            }
            break;
        }
        for(int i=left;i<right;i++){
            if(s.charAt(i)=='0') res++;
        }
        return res;
    }

    public static int minCost(String s) {
        int n = s.length();
        int firstOne = -1;
        int lastOne = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                if (firstOne == -1) {
                    firstOne = i;
                }
                lastOne = i;
            }
        }
        int leftZeros = 0;
        int rightZeros = 0;
        for (int i = 0; i < firstOne; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            }
        }
        for (int i = lastOne + 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                rightZeros++;
            }
        }
        int cost = 0;
        for (int i = firstOne; i <= lastOne; i++) {
            if (s.charAt(i) == '1') {
                cost++;
            }
        }
        return Math.min(leftZeros + cost + rightZeros, n - cost);
    }

    public static int getMinCost(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        int cnt1l = 0, cnt1r = 0, cnt0 = 0;
        int minCost = Integer.MAX_VALUE;
        while (l < n && s.charAt(l) == '0') {
            l++;
        }
        while (r >= 0 && s.charAt(r) == '0') {
            r--;
        }
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '1') {
                cnt1l++;
            }
        }
        cnt1r = cnt1l;
        for (int i = r; i >= l; i--) {
            if (s.charAt(i) == '1') {
                cnt1r--;
            }
            else {
                cnt0++;
            }
            minCost = Math.min(minCost, cnt1l + cnt1r + cnt0);
        }
        return minCost;
    }

}
