package interview.zhuoyv;
import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int len =str.length();
        int ans = 0;
        //奇数
        for(int i=0;i<len;i++){
            int l = i;
            int r = i;
            while (l>=0&&r<len&&str.charAt(l)==str.charAt(r)){
                ans++;
                l--;
                r++;
            }
        }
        //偶数
        for(int i=0;i<len;i++){
            int l = i;
            int r = i;
            if(l>=0&&r<len&&str.charAt(l)==str.charAt(r)){
                r=l+1;
            }
            while (l>=0&&r<len&&str.charAt(l)==str.charAt(r)){
                ans++;
                l--;
                r++;
            }
        }
        System.out.println(ans);
    }

}
