package leetcode.meituan;
import java.util.Scanner;
public class Q1_1 {
//小团班级的座位排成了 n 行（行从 1 到 n 编号），共有 m 个大列（大列从 1 到 m 编号），每个大列中有 a 个小列（小列从 1 到 a 编号），
// 大列与大列之间有一个过道。小团的班级每周会换一次座位，首先所有同学都换到后一行，最后一行的同学换到第一行，
// 然后所有同学都移动到自己右边的那个大列的相同小列上，在最右大列的同学移动到最左大列。换句话说，对于坐在第 i<n 行的同学，
// 新位置在第 i+1 行，如果 i=n，那么新位置在第一行；对于坐在第 j<m 大列的同学，新位置在第 j+1 大列，如果 j=m，
// 那么新位置在第一大列；对于坐在第 k 小列的同学，新位置仍然在第 k 小列。
//小团的学校最近换了一批学生桌椅。这批学生桌椅的优点在于可以调节桌子的高度，一些同学调整了桌子高度，但是另一些没有。
// 这样换座就变得麻烦了起来，如果一位调整了桌子高度的同学换到了未调整桌子高度同学的位置，他就会调整新位置的桌子到他想要的高度，
// 而一位没有调整桌子高度的同学换到了调整过桌子高度同学的位置，他也会调整新位置的桌子高度，使其恢复原高度。
//现在小团的班级要进行换座位了，给出换座位前班级所有桌子的情况，小团想知道，换一次位置后，有多少同学需要重新调整桌子高度。

//输入描述
//输入第一行包含三个数 n, m, a，意义如题目所示。
//接下来 n 行，每行 m 个长度为 a 的 01 字符串，表示目前小团班上的桌子情况。其中 0 表示这个位置未调节桌子高度，1 表示已调节桌子高度。
//对于全部数据，1 ≤ n, m ≤ 200, n × m ≥ 2, 1 ≤ a ≤ 5。
//输出描述
//输出一行一个整数，表示换座位后有多少同学需要重新调整桌子高度。
//样例输入
//3 3 2
//01 10 00
//10 00 11
//01 00 00
//样例输出
//8
    // 定义一个辅助类型
    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // 定义一个函数，实现题目要求的功能
    static void solve(int cas) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();

        String[][] s = new String[205][205];
        String[][] change = new String[205][205];

        // 读入矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[i][j] = sc.next();
            }
        }

        // 构造change矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r = (i - 1 + n) % n, c = (j - 1 + m) % m;
                change[i][j] = s[r][c];
                System.err.print(change[i][j]);  // 输出调试信息
            }
            System.err.println();
        }

        int ans = 0;
        // 计算改变的位数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < a; k++) {
                    if (s[i][j].charAt(k) != change[i][j].charAt(k)) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);  // 输出答案
    }

    public static void main(String[] args) {
        int T = 1;
        //Scanner sc = new Scanner(System.in);
        //T = sc.nextInt();
        while (T-- > 0) {
            solve(T);
        }
    }
}
