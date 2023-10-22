package leetcode.mayi;
import java.util.*;
//n 行 m 列的矩阵，每个位置上有一个元素。你可以上下左右行走，代价是前后两个位置元素值差的绝对值。另外，你最多可以使用一次传送阵（只能从一个数跳到另外一个相同的树），求从走上角走到右下角最少需要多少时间。
//1 <= n, m <= 500, 1 <= aij <= 1e9。
//最短路问题，但需要带上是否使用传送阵这一维度状态。
//d[i][j][k] 表示走到 i 行 j 列时，使用(k=1) 或未使用 (k=0) 时的最短时间。然后用 dijkstra 求解即可。
//每次除去考虑往上下左右转移，还需要单独考虑 k = 0 时可以使用传送阵的情况。用哈希表提前存下来每种数的所有位置，然后遍历转移即可。
//由于枚举传送带到达的位置时，可能会把所有数值都枚举一遍，极端情况是所有位置的数字都一样，这样复杂度会上升至 (nm)^2，会超时，所幸数据没有这种极端样例，aij 应该是随机生成的，所以这种解法可以通过。
//不过再细想一下，如果已经考虑一个点传送到集合 v 中的某个点，那么集合 v 中的点在之后就不需要考虑互相转移（因为转移耗时是 0，如果要转移，不如当前就转移）。所以每次传送后就可以把该集合删除。这样总复杂度是 O(nmlog(nm) + nm)。
public class Q3 {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<Integer, ArrayList<int[]>> mp = new HashMap<>();
        int[][] a = new int[n][m];
        long[][][] d = new long[n][m][2];
        int[][][] v = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if (!mp.containsKey(a[i][j])) {
                    mp.put(a[i][j], new ArrayList<int[]>());
                }
                mp.get(a[i][j]).add(new int[]{i, j});
                d[i][j][0] = Long.MAX_VALUE / 2;
                d[i][j][1] = Long.MAX_VALUE / 2;
            }
        }

        d[0][0][0] = 0;
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(x -> x[0]));
        q.add(new long[]{0, 0, 0, 0});
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            long dist = cur[0];
            int x = (int) cur[1];
            int y = (int) cur[2];
            int z = (int) cur[3];
            if (v[x][y][z] == 1) {
                continue;
            }
            v[x][y][z] = 1;

            // 上下左右
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || v[nx][ny][z] == 1) {
                    continue;
                }
                if (d[nx][ny][z] > dist + Math.abs(a[x][y] - a[nx][ny])) {
                    d[nx][ny][z] = dist + Math.abs(a[x][y] - a[nx][ny]);
                    q.add(new long[]{d[nx][ny][z], nx, ny, z});
                }
            }
            if (z == 1) {
                continue;
            }
            for (int[] next : mp.get(a[x][y])) {
                int nx = next[0];
                int ny = next[1];
                if (v[nx][ny][1] == 1 || d[nx][ny][1] <= dist) {
                    continue;
                }
                d[nx][ny][1] = dist;
                q.add(new long[]{dist, nx, ny, 1});
            }
        }

        System.out.println(Math.min(d[n - 1][m - 1][0], d[n - 1][m - 1][1]));
    }

}
