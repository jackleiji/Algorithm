package interview.baidu;

import java.util.*;

public class Question3 {
//    给定一棵树，每个节点有蓝色和红色两种颜色，问：删除其中一条边，剩下两个联通块的色块的个数的差值，求所有差值的和；（n<2e5)
//    输入一颗树，树的节点有红色的和蓝色的两种。定义每条边的权重为删除该边后两个连通分支各自的同色子连通块数差的绝对值。输出树中所有边权重之和。

//给你一棵 $n$ 个节点的树和一个字符串 $s$，每个节点都可以染成 $r$、$g$、$b$ 中的一种颜色。
//    你需要找到一个方案，使得对于树上的任意两个节点 $u$ 和 $v$，$u$ 到 $v$ 的路径上的颜色组成的字符串不同于 $s$ 的子串数量最小，并输出这个最小数量。
//    该算法使用了树形动态规划的思想。具体地，先进行树形 DFS 预处理，对于每个节点 $x$ 维护其子树内的染色方案数目 $dp_x$，
//    同时将相同颜色的子节点合并为一块。接着，再进行一次 DFS 进行计算。对于每个节点 $x$，考虑其染上与其父节点 $y$ 不同颜色所增加的颜色块数目和染上与其父节点 $y$ 相同颜色所减少的颜色块数目，
//    通过一些计算，即可得到 $y$ 子树内所有染上不同颜色方案数目之和与 $y$ 父亲子树内所有染上不同颜色方案数目之和的差值，最后累加即可。
//    值得注意的是，Java 代码在定义静态变量和读取输入的时候都需要加上 static 关键字。另外，在判断两个字符是否相等时，
//    Java 使用的是 char 类型而不是 String 类型，因此需要使用 charAt 方法来访问字符串中的某个字符。
//    in
//    4
//    RRBB
//    1 2
//    2 3
//    1 4
//    out:2
    static final int N = 200010;
    static int n;
    static String s;
    static List<Integer>[] edge = new List[N];
    static long sum, ans;
    static long[] dp = new long[N];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        s = input.next();
        for (int i = 0; i < n; i++) {
            edge[i] = new ArrayList<>(); }
        for (int i = 1; i < n; i++) {
            int x = input.nextInt() - 1;
            int y = input.nextInt() - 1;
            edge[x].add(y);
            edge[y].add(x); }
        sum = init(0, -1);
        dfs(0, -1);
        System.out.println(ans);
    }
    public static long init(int x, int fa) {
        dp[x] = 1;
        for (int y : edge[x]) {
            if (y == fa) continue;
            dp[x] += init(y, x);
            // 如果子节点与父节点颜色相同，合并为一个块
            if (s.charAt(x) == s.charAt(y)) dp[x]--; }
        return dp[x];
    }
    public static void dfs(int x, int fa) {
        for (int y : edge[x]) {
            if (y == fa) continue;
            dfs(y, x);
            long son = dp[y];
            // 父亲节点所拥有的颜色块的数目为：总-儿子节点颜色块的数目+分割产生的一个颜色块
            long father = sum - son +
                    (s.charAt(x) == s.charAt(y) ? 1 : 0);
            ans += Math.abs(father - son); }
    }
}
