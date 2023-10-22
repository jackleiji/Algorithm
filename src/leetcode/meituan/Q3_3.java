package leetcode.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
小美不干外卖配送了，转行开了一家水果店。
一天她接到了一个大单，客户订购了 n 个水果，并且要求打包成多个果篮，一个果篮最多装 m 个水果。
为了包装方便，水果按从 1 到 n 编号，同一个果篮里装的水果编号必须是连续的。果篮的成本与容积成线性关系。为了估计容积，
小美简单地用样本中点估计了一下。具体来说，假设一个果篮中装的最大的水果体积是 u，最小的是 v，
那么这个果篮的成本就是 k × floor((u+v)/2) + s，其中 k 是果篮中装入水果的个数，s 是一个常数，floor(x) 是下取整函数，比如 floor(3.8)=3, floor(2)=2。
客户并没有规定果篮的数量，但是希望果篮的成本越小越好，毕竟买水果就很贵了。请求出小美打包这 n 个水果所用的最小花费。
输入描述
第一行三个正整数 n, m, s。意义如题面所示。

第二行 n 个正整数 a1, a2, ..., an，表示每个水果的体积。

对于全部数据，1 ≤ n ≤ 1e4,   1 ≤ m ≤ 1e3,   m ≤ n,   1 ≤ ai, s ≤ 1e4。

输出描述
输出一个整数，表示打包这 n 个水果果篮的最小成本。

样例输入
6 4 3
1 4 5 1 4 1
样例输出
21
*/
/*
该程序使用深度优先搜索（DFS）来查找从节点from到节点to的路径上的最大距离，然后将两个距离相加即可得到答案。
由于这是一个无向图，我们需要将每条边添加两次，即从fa到i和从i到fa都要添加。dist数组保存了每个节点的距离，
而res则保存了路径上的最大距离。我们使用两次DFS来计算最大距离。
*/
public class Q3_3 {
    static int n, m, s;
    static long[] A, dp;
    static long[][] cache_max, cache_min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        s = Integer.parseInt(input[2]);

        A = new long[n+1];
        dp = new long[n+1];
        cache_max = new long[n+1][n+1];
        cache_min = new long[n+1][n+1];

        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(input[i-1]);
            dp[i] = Long.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            long max_obj = 0, min_obj = Integer.MAX_VALUE;
            for (int j = i; j <= n; j++) {
                max_obj = Math.max(max_obj, A[j]);
                min_obj = Math.min(min_obj, A[j]);
                cache_max[i][j] = max_obj;
                cache_min[i][j] = min_obj;
            }
        }

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int last = Math.max(i - m, 0); last <= i - 1; last++) {
                dp[i] = Math.min(dp[i], dp[last] + cal(last + 1, i));
            }
        }

        System.out.println(dp[n]);
    }

    static long cal(int l, int r) {
        long Max = cache_max[l][r];
        long Min = cache_min[l][r];
        int k = r - l + 1;
        return 1L * k * ((Max + Min) / 2) + s;
    }
}
