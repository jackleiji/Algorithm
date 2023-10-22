package interview.meituan;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {
        //给n个数，原始情况下就是对这n个数进行加法计算。
        // 现在对该加法串进行m次操作，每次操作将其中一个加法换成加减乘除中的一种重新计算整组数的值，
        // 每次操作之间是相互独立互不影响的。
        //    第一行输入整数n
        //            接下来一行输入n个整数
        //接下来输入一个整数m
        //接下来输入2m个以空格分开的数字或者符号t1, o1, t2, o2 ... 其中t为数字，o为符号，表示第i次操作选取第ti个加号改变为oi。
        //输出一行m个数字分别表示每次操作的后的答案，四舍五入保留一位小数。
        //用例：
        //输入：
        //        5
        //        1 2 4 2 5
        //        3
        //        1 - 2 * 4 /
        //输出：
        //        10.0 16.0 7.4
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            List<Integer> nums = new ArrayList<>();
            double sum = 0;
            //输入数字
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                nums.add(num);
                sum += num;
            }
            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                int idx = scanner.nextInt();
                char op = scanner.next().charAt(0);
                int num1 = nums.get(idx - 1);
                int num2 = nums.get(idx);
                double ans = sum;
                ans-=num1;
                ans-=num2;
                switch (op) {
                    case '+':
                        ans += num1 + num2;
                        break;
                    case '-':
                        ans += num1 - num2;
                        break;
                    case '*':
                        ans += num1 * num2;
                        break;
                    case '/':
                        ans += (double) num1 / (double) num2;
                        break;
                }
                System.out.printf("%.1f\n", ans);
            }
            scanner.close();
        }
}
