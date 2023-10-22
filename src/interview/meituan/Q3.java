package interview.meituan;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读入n和m
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 创建初始数组a，初始值全部为0
        List<Integer> a = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            a.add(0);
        }
        // 读入操作op、x、y
        List<Integer> op = new ArrayList<Integer>(m);
        List<Integer> x = new ArrayList<Integer>(m);
        List<Integer> y = new ArrayList<Integer>(m);
        for (int i = 0; i < m; i++) {
            op.add(sc.nextInt());
            x.add(sc.nextInt());
            y.add(sc.nextInt());
        }
        // 对操作进行处理
        //先从标准输入读入两个整数n和m，然后读入m行操作，每行操作包含三个整数op、x和y，
        //表示进行赋值操作或求和操作。对于每个赋值操作，将a[x]的值设置为y；对于每个求和操作，将a[x]至a[y]的值相加并输出。
        for (int i = 0; i < m; i++) {
            if (op.get(i) == 0) { // 如果是赋值操作
                a.set(x.get(i), y.get(i));
            } else { // 如果是求和操作
                int ans = 0;
                //将a[x]至a[y]的值相加并输出。
                for (int j = x.get(i); j <= y.get(i); j++) {
                    ans += a.get(j);
                }
                System.out.print(ans + " ");
            }
        }
        // 关闭输入流
        sc.close();
    }
}
