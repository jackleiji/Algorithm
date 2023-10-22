package leetcode.meituan;
import java.util.*;
import java.io.*;

public class Q4_4 {
    static final int INF = (int) Integer.MAX_VALUE;
    /*
    第一个算法是一个动态规划算法，解决了一个最小代价的区间划分问题。给定一个长度为 $n$ 的序列 $A$，
    要将其划分为若干个长度不超过 $m$ 的区间，每个区间的代价为区间中的最大值和最小值的平均数加上一个固定值 $s$。求使得所有区间的代价之和最小的划分方案。

    该算法使用动态规划，定义 $dp_i$ 表示将前 $i$ 个数划分为若干个区间的最小代价。
    状态转移方程为 $dp_i = \min_{j=0}^{i-1}{dp_j + cal(j+1, i)}$，其中 $cal(l, r)$ 表示区间 $[l, r]$ 的代价。
    为了避免重复计算，可以使用一个类似于线段树的数据结构来维护区间最大值和最小值，也可以像代码中注释部分那样暴力计算。

    第二个算法是一个 Dijkstra 算法，解决了一个最短路问题。给定一个 $n\times m$ 的网格图，其中有 $k$ 个障碍物，
    每个障碍物位于一个不同的格子上，求从 $(x_1, y_1)$ 到 $(x_2, y_2)$ 的最短路。
    其中，从一个格子到相邻的格子的代价为 $1$，从一个格子到一个障碍物的距离为该格子到该障碍物的曼哈顿距离。

    该算法使用了 Dijkstra 算法。首先，预处理出从每个格子到所有障碍物的最短距离。然后从起点 $(x_1, y_1)$ 开始进行 Dijkstra 算法，
    每次取出距离起点最短的未访问的格子，更新其相邻格子的最短路距离。具体地，若相邻格子 $(nx, ny)$ 未访问，且从起点到该相邻格子的距离比当前已知的最短路距离更短，
    则更新该相邻格子的最短路距离，并将其加入 Dijkstra 队列。最后，最短路的长度即为从起点到终点的最短路距离。
    */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        // T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int k = Integer.parseInt(line[2]);
            int[] X = new int[k + 1];
            int[] Y = new int[k + 1];
            int[][] dist = new int[n + 1][m + 1];
            int[][] dp = new int[n + 1][m + 1];
            boolean[][] vis = new boolean[n + 1][m + 1];
            int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int i = 1; i <= k; i++) {
                line = br.readLine().split(" ");
                X[i] = Integer.parseInt(line[0]);
                Y[i] = Integer.parseInt(line[1]);
            }
            for (int i = 1; i <= n; i++) {
                Arrays.fill(dist[i], INF);
                for (int j = 1; j <= m; j++) {
                    for (int u = 1; u <= k; u++) {
                        int distance = Math.abs(i - X[u]) + Math.abs(j - Y[u]);
                        dist[i][j] = Math.min(dist[i][j], distance);
                    }
                }
            }
            line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.offer(new int[]{dist[x1][y1], x1, y1});
            dp[x1][y1] = dist[x1][y1];
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int cost = cur[0];
                int x = cur[1];
                int y = cur[2];
                if (vis[x][y]) {
                    continue;
                }
                vis[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if (nx <= 0 || ny <= 0 || nx > n || ny > m) {
                        continue;
                    }
                    if (!vis[nx][ny] && dp[nx][ny] < Math.min(dist[nx][ny], dp[x][y])) {
                        dp[nx][ny] = Math.min(dist[nx][ny], dp[x][y]);
                        pq.offer(new int[]{dp[nx][ny], nx, ny});
                    }
                }
            }
            System.out.println(dp[x2][y2]);
        }
    }
}
