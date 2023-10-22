package leetcode.meituan;

import java.util.*;

/*

题目描述：
有一棵 n 个节点的树，树上每个点都有红绿蓝三种颜色中的一种。定义一棵树是多彩的，当且仅当这棵树同时存在一个红色节点，一个蓝色节点和一个绿色节点。
保证最初这棵树是多彩的，现在要砍掉这棵树的某一条边，请问有多少种砍法，使得砍完之后形成的两棵树都是多彩的。

输入描述
第一行一个整数 n，表示节点个数。
第二行 n-1 个整数 p2, p3, ..., pn，pi 表示树上 i 和 pi 两点之间有一条边。保证给出的一定是一棵树。
第三行一个长度为 n 的字符串，第 i 个字符表示第 i 个节点的初始颜色。其中 R 表示红色，G 表示绿色，B 表示蓝色。保证字符串只由这三种大写字母构成。
对于全部数据，3≤n≤1e5。

输出描述
输出一行，一个正整数，表示答案。

样例输入
7
1 2 3 1 5 5
GBGRRBB
样例输出
1
*/
/*
    该算法的主要思路是，先使用深度优先搜索（DFS）求出每个节点周围的红、绿、蓝三种颜色的节点数量，然后遍历每条边，
    判断该边连接的两个节点是否同时包含红、绿、蓝三种颜色的节点，并且剔除掉这条边后，红、绿
 */
public class Q5_5 {
    // 定义一个边
    static class Edge {
        int u, v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    // 定义一个节点
    static class Node {
        int szR, szG, szB;
        ArrayList<Integer> G;

        Node() {
            szR = szG = szB = 0;
            G = new ArrayList<>();
        }
    }

    static int tot;
    static Node[] nodes;
    static char[] color;

    // 深度优先搜索求解各个颜色的节点数量
    static void dfs(int u, int par) {
        if (color[u] == 'R') {
            nodes[u].szR++;
        } else if (color[u] == 'G') {
            nodes[u].szG++;
        } else {
            nodes[u].szB++;
        }

        for (int v : nodes[u].G) {
            if (v == par) {
                continue;
            }
            dfs(v, u);
            nodes[u].szR += nodes[v].szR;
            nodes[u].szG += nodes[v].szG;
            nodes[u].szB += nodes[v].szB;
        }
    }

    static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }

        for (int i = 2; i <= n; i++) {
            int fa = sc.nextInt();
            tot++;
            Edge e = new Edge(i, fa);
            nodes[i].G.add(fa);
            nodes[fa].G.add(i);
        }

        color = sc.next().toCharArray();

        int R = 0, G = 0, B = 0;
        for (int i = 1; i <= n; i++) {
            if (color[i] == 'R') {
                R++;
            } else if (color[i] == 'G') {
                G++;
            } else {
                B++;
            }
        }

        dfs(1, 0);

        int ans = 0;
//        for (int i = 1; i <= tot; i++) {
//            int u = nodes[i]., v = nodes[i];
//            if (nodes[u].szR > 0 && nodes[u].szG > 0 && nodes[u].szB > 0) {
//                if (R - nodes[u].szR > 0 && G - nodes[u].szG > 0 && B - nodes[u].szB > 0) {
//                    ans++;
//                }
//            }
//        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}
