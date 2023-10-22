package interview.meituan0819;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        long q = in.nextInt();
        for(long i=0;i<q;i++){
            long a = in.nextInt();
            long b = in.nextInt();
            long numb = b%a;
            System.out.println(numb==0?a:numb);
        }
    }
}
