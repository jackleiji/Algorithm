package interview.xiecheng;

public class Q3 {
    public static long[] solve(long n) {
        int d = String.valueOf(n).length();
        long ans = Long.MAX_VALUE;
        long xAns = 0, yAns = 0;
        for (long x = 3; x <= n; x++) {
            long yMax = (long) Math.pow(10, d);
            for (long y = 3; y <= yMax; y++) {
                if (x == 2 || y == 2) {
                    continue;
                }
                long res = Math.abs(y * factorial(x) - y - n);
                if (res < ans) {
                    ans = res;
                    xAns = x;
                    yAns = y;
                }
            }
        }
        return new long[]{xAns, yAns};
    }

    public static long factorial(long n) {
        if (n <= 1) {
            return 1;
        }
        long res = 1;
        for (long i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

}
