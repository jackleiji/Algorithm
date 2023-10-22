package leetcode.mayi;
import java.util.*;
public class Q1 {
//    1e14 范围以内的一个正整数，将其每一数位上的奇数和偶数分别抽取出来组成两个新的数字，求这两差的绝对值。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        long odd = 0, even = 0;
        for (char c : s.toCharArray()) {
            if ((c - '0') % 2 == 1) {
                odd = odd * 10 + c - '0';
            } else {
                even = even * 10 + c - '0';
            }
        }
        System.out.println(Math.abs(odd - even));
    }
}
