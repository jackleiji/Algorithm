package leetcode.xiecheng;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        StringBuilder sb = new StringBuilder();
        // 6 3
        // 4 1 5 2 6 3
        int insert = n-k+1;
        for (int i = 1; i <= n-k ; i++) {
            if ( insert <= n ) {
                sb.append(insert).append(" ");
                insert++;
                sb.append(i).append(" ");
            } else {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
