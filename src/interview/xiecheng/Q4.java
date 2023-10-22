package interview.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {

    private static List<Integer>[] G;
    private static int[] color;
    private static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        G = new ArrayList[n + 1];
        color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            G[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            int u = sc.nextInt();
            int fa = sc.nextInt();
            int w = sc.nextInt();
            if (fa != 0) {
                G[fa].add(u);
            }
            color[u] = w;
        }
        dfs(1, 0);
        System.out.println(ans);
    }

    private static int[] dfs(int u, int fa) {
        int[] res = new int[2];
        res[0] = color[u];
        for (int v : G[u]) {
            if (v == fa) {
                continue;
            }
            int[] tmp = dfs(v, u);
            if (tmp[0] > res[0]) {
                res[1] = res[0];
                res[0] = tmp[0];
            } else if (tmp[0] > res[1]) {
                res[1] = tmp[0];
            }
        }
        if (res[1] > 0) {
            ans = Math.max(ans, res[0] + res[1]);
        }
        return res;
    }
}
