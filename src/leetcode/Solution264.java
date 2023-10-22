package leetcode;

public class Solution264 {
    public int nthUglyNumber(int n) {
        //小顶堆：求值排序
//        int[] factors = {2,3,5};
//        int ugly = 1;
//        Set<Long> set = new HashSet<>();
//        Queue<Long> queue = new PriorityQueue<>();//优先级队列
//        set.add(1L);
//        queue.offer(1L);
//        for(int i=1;i<n;i++){
//            long cur = queue.poll();
//            ugly = (int) cur;
//            for(int factor : factors){
//                if(set.add((long)ugly*factor)){
//                    queue.offer((long)ugly*factor);
//                }
//            }
//        }
//        return ugly;
        //2.动态规划：
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            //消除重复项
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
