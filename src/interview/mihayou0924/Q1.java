package interview.mihayou0924;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int aSum = 0;
        int aMax = 0;
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
            aSum += a[i];
//            aMax = Math.max(aMax,a[i]);
        }
        int bSum = 0;
        int bMax = 0;
        for(int i = 0;i<n;i++){
            b[i] = in.nextInt();
            bSum += b[i];
//            bMax = Math.max(bMax,b[i]);
        }
//        System.out.println(aMax>=bMax?(aSum-aMax)^bSum:aMax^(bSum-bMax));
        int res = 0;
        for(int i = 0;i<n;i++){
            res = Math.max(res,Math.max(aSum^(bSum-b[i]),(aSum-a[i])^bSum));
        }
        System.out.println(res);
    }
}
