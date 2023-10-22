package interview.xiecheng;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        // 0 6 9 -> 1
        // 8 - > 2
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0' || c=='6' || c=='9') ++res;
            else if ( c=='8' ) res += 2;
        }
        System.out.println(res);
    }
}
