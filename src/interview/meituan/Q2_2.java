package interview.meituan;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
题目描述：
有一棵 n 个节点的树，有一条边被选定。小美想知道对于所有经过这条选定边的所有树上简单路径，最长的那条有多长。一条简单的路径的长度指这条简单路径上的边的个数。
输入描述
第一行一个整数 n，表示树的节点个数。

第二行 n-1 个整数，第 i 个整数 pi 表示节点 i+1 和 pi 之间有一条边相连。

第三行两个整数 x, y，表示这条选定的边。保证这条边一定是树上的一条边。

对于全部数据，2 ≤ n ≤ 1e5, 1 ≤ pi ≤ n, 1 ≤ x, y ≤ n, x ≠ y。保证输入数据正确描述一棵树，并且 (x, y) 是树上的一条边。
输出描述
输出一行，一个整数，表示所有经过选定边的树上简单路径中，最长的那条的长度。
样例输入
7
1 2 3 4 5 3
3 7
样例输出
4
*/
/*
该程序使用深度优先搜索（DFS）来查找从节点from到节点to的路径上的最大距离，然后将两个距离相加即可得到答案。
由于这是一个无向图，我们需要将每条边添加两次，即从fa到i和从i到fa都要添加。dist数组保存了每个节点的距离，
而res则保存了路径上的最大距离。我们使用两次DFS来计算最大距离。
*/
public class Q2_2 {
    static List<Integer>[] G;
    static int[] dist;
    static int res = 0;
    static void dfs(int u, int par) {
        res = Math.max(res, dist[u]);
        for (int v : G[u]) {
            if (v == par) {
                continue;
            }
            dist[v] = dist[u] + 1;
            dfs(v, u);
        }
    }

    static void solve(int cas) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        G = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            G[i] = new ArrayList<>();
        }
        for (int i = 2; i <= n; i++) {
            int fa = in.nextInt();
            G[fa].add(i);
            G[i].add(fa);
        }
        dist = new int[n + 1];
        int from = in.nextInt();
        int to = in.nextInt();
        dfs(from, to);
        int ans = 1 + res;
        res = 0;
        dfs(to, from);
        ans += res;
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int T = 1;
        //Scanner in = new Scanner(System.in);
        //T = in.nextInt();
        while (T-- > 0) {
            solve(T);
        }
    }
}
