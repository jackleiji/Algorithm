package interview.baidu;
import java.util.*;
//给定数字p，构造s使得s的子字符串为回文串的数目为p。(p<1e9,s.size() < 1e5);
//输入x，用“r ”“e ”“d”三个字母构造含有x个回文子串的字符串。ac 。
public class Question2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        String s = "", red = "red";

        int c = 0;
        while (x > 0) {
            int sum = 0, i = 1;
            while (sum + i <= x) {
                // 构造连续相同的c
                sum += i;
                i++;
                s += red.charAt(c);
            }
            System.out.println(x);
            x -= sum;
            c = (c + 1) % 3;
        }
        System.out.println(s);
    }
}