package interview.meituan0812;

import java.util.*;
import java.util.Scanner;

public class Q5 {
    static int N = 10;
    static int[][] dp = new int[N][2];
    static int[] h = new int[N];//节点的一条边
    static int[] e = new int[N];//邻接节点
    static int[] ne = new int[N];//下一条边的索引
    static int index = 0;
    static int[] happy = new int[N];
    static boolean[] vis = new boolean[N];
    static int n;

    static void insert(int b,int a){
        e[index] = a;
        ne[index] = h[b];
        h[b] = index++;
    }
    static void dfs(int root){
        dp[root][1] = happy[root];
        for(int i=h[root];i!=-1;i=ne[i]){
            int j = e[i];
            System.out.println(j);
            dfs(j);
            dp[root][0] += Math.max(dp[j][0],dp[j][1]);
            dp[root][1] += dp[j][0];
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i=1;i<=n;i++){
            happy[i] = scan.nextInt();
        }
        Arrays.fill(h,-1);
        for(int i=0;i<n-1;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            insert(b,a);
            vis[a] = true;//a有父节点
        }
        int root = 1;
        while (vis[root]) root++;
        dfs(root);
        System.out.println(Arrays.toString(vis));
        System.out.println(Arrays.toString(e));
        System.out.println(Arrays.toString(ne));
        System.out.println(Arrays.toString(h));
        for(int[] i:dp){
            System.out.println(Arrays.toString(i));
        }
        System.out.println(Math.max(dp[root][1],dp[root][0]));
    }
}
//7
//1
//1
//1
//1
//1
//1
//1
//1 3
//2 3
//6 4
//7 4
//4 5
//3 5