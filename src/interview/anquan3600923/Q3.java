package interview.anquan3600923;

import java.util.Scanner;

public class Q3 {
    //求逆元
    private static final long MOD = 1000000007; // 10^9 + 7

    public static long calculateFractionMod(long numerator, long denominator) {
        long numeratorMod = numerator % MOD;
        long denominatorInverse = modInverse(denominator);
        System.out.println(numeratorMod+" "+denominatorInverse);
        // 计算分子模 MOD
        long result = (numeratorMod * denominatorInverse) % MOD;
        return (result + MOD) % MOD; // 确保结果为非负数
    }

    // 计算模逆元
    private static long modInverse(long a) {
        return power(a, MOD - 2);
    }

    // 快速幂算法
    private static long power(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        long numerator = scanner.nextLong();
//        long denominator = scanner.nextLong();

        long result = calculateFractionMod(1, 2);
        System.out.println("Result: " + result);
    }
}

