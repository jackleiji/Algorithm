package interview.baidu;

import java.util.*;
//拿到了一个01串，她每次可以选择一个长度为2的连续子串，每次需要同取反连续子串，
//是否能在有限的操作次数内使得所有字符全为0或全为1？如输入3 101，输出yes
public class Question2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(canMakeAllSame(n, s) ? "yes" : "no");
    }

    private static boolean canMakeAllSame(int n, String s) {
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if (chars[i] != chars[i - 1]) {
                cnt++;
                chars[i - 1] = (chars[i - 1] == '1') ? '0' : '1';
            }
        }
        return cnt <= 1;
    }
}
