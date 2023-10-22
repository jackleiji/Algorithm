package interview.zijie0917;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        long res = 0;
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i] = in.nextInt();
            c[i] = Math.max(b[i],a[i]);
            res += c[i];
        }
        for(int i =0;i<q;i++){
            int op = in.nextInt();
            int x = in.nextInt()-1;
            int y = in.nextInt()-1;
            res = res-c[x]-c[y];
            if(op==1){
                int temp = a[x];
                a[x] = a[y];
                a[y] = temp;
            }else {
                int temp = b[x];
                b[x] = b[y];
                b[y] = temp;
            }
            c[x] = Math.max(a[x], b[x]);
            c[y] = Math.max(a[y], b[y]);
            res = res+c[x]+c[y];
            System.out.println(res);
        }
    }
}
