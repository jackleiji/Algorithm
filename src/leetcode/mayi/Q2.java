package leetcode.mayi;
import java.util.*;
//n 组零件，每组零件有若干种，每一种有一个价格和性能。你需要从每组里面选出一种零件，使得总价格不超过 x，并且性能总和最大。
//n <= 40, 所有零件的种类数不超过 40，其他数值 1e9。
//注意到总的零件种类不超过 40，假设平分到 p 干个组，
// 然后暴力枚举的复杂度是 (40 / p) ^ p。当 p 是 20 时复杂度是 2^20，当 p 是 13 时复杂度是 3^13... 依次类推发现完全可以暴力。
//应该可以证明当每组种类数是 3 时，要枚举的情况数是最多的。对 p 求一下倒数。
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long all = scanner.nextLong();
        List<List<Integer>> v = new ArrayList<>();
        List<List<Integer>> w = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            List<Integer> vList = new ArrayList<>();
            List<Integer> wList = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                vList.add(scanner.nextInt());
            }
            for (int j = 0; j < m; j++) {
                wList.add(scanner.nextInt());
            }
            v.add(vList);
            w.add(wList);
        }
        long[] res = {-1};
        dfs(0, 0, 0, n, all, v, w, res);
        System.out.println(res[0]);
    }
    private static void dfs(int cur, long tot, long sum, int n, long all, List<List<Integer>> v, List<List<Integer>> w, long[] res) {
        if (cur == n) {
            res[0] = Math.max(res[0], sum);
            return;
        }
        for (int i = 0; i < v.get(cur).size(); i++) {
            // 超出预算则跳过
            if (tot + v.get(cur).get(i) > all) {
                continue;
            }
            dfs(cur + 1, tot + v.get(cur).get(i), sum + w.get(cur).get(i), n, all, v, w, res);
        }
    }
}
