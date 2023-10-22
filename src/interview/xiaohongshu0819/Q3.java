package interview.xiaohongshu0819;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//景点
        int m = scan.nextInt();//线路
        int k = scan.nextInt();//总时间
        int[] a = new int[n];//景点价值
        for(int i=0;i<n;i++){
            a[i] = scan.nextInt();
        }
        int[] h = new int[n];//参观时间
        int[][] trafficTime = new int[m][3];//u,v之间的交通时间
        System.out.println(a[0]+a[1]+a[2]);

    }
}
