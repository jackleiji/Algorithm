package interview.meituan;
import java.util.Scanner;
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < m; i++) {
            int op = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt();
            if (op == 0) {
                a[x] = y;
            } else {
                int sum = 0;
                for (int j = x; j < y; j++) {
                    sum += a[j];
                }
                System.out.println(sum);
            }
        }
    }
}
