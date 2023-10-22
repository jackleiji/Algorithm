package interview.huawei1;
import java.util.*;
//这个函数的作用是计算给定的一个有向无环图中，从图中所有入度为0的点开始进行遍历所需要的最少步数。
//函数首先读取输入数据，建立图的邻接表表示，并记录每个点的入度，同时将所有入度为0的点加入一个列表 now 中。然后，从 now 列表中的每个点开始，
// 将它们的所有出度相邻的点的入度减1，如果此时入度变为0，则将该点加入到一个新的列表 tmp 中。遍历完 now 列表中的所有点后，将 now 重置为 tmp，
// 开始下一轮遍历，直到 now 为空。在遍历的过程中，记录遍历的轮数，即为所求的最少步数。
//最后，函数检查所有点的入度是否为0，如果存在入度不为0的点，则表示有环，返回 -1。如果所有点的入度均为0，则返回遍历的轮数 ans，即为所求的结果。
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<List<Integer>> g = new ArrayList<>(N + 1);
        int[] cnt = new int[N + 1];
        List<Integer> now = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<Integer>());
        }
        for (int i = 1; i <= N; i++) {
            cnt[i] = sc.nextInt();
            if (cnt[i] == 0) {
                now.add(i);
            }
            for (int j = 0, k; j < cnt[i]; j++) {
                k = sc.nextInt();
                g.get(k).add(i);
            }
        }
        int ans = 0;
        while (!now.isEmpty()) {
            ans++;
            List<Integer> tmp = new ArrayList<>();
            for (int u : now) {
                for (int v : g.get(u)) {
                    cnt[v]--;
                    if (cnt[v] == 0) {
                        tmp.add(v);
                    }
                }
            }
            now = tmp;
        }
        for (int i = 1; i <= N; i++) {
            if (cnt[i] > 0) {
                ans = -1;
                break;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}

