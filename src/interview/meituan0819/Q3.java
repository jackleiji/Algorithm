package interview.meituan0819;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String data = in.next();
        long res = 0;
        Map<String,Long> map = new HashMap<>();
        for(int i=0;i<data.length();i++){
                String temp = data.substring(i,data.length());
//                System.out.println(temp);
                long change = compareDiffer(temp);
                res += change;
        }
        System.out.println(res);
    }
    //暴力破解，求给定字符串01变换的最小变换次数
    static long compareDiffer(String numb){
        int len = numb.length();
        int zeroStart = 0;
        int oneStart = 1;
        int zNumb = 0;
        int oNumb = 0;
        int res = 0;
        for(int i=0;i<len;i++){
            int temp = Integer.parseInt(numb.substring(i,i+1));
            if(temp!=zeroStart){
                zNumb +=1;
            }
            if(temp!=oneStart){
                oNumb +=1;
            }
            zeroStart = zeroStart==0?1:0;
            oneStart = oneStart==1?0:1;
            if(i>0){
                res+=Math.min(zNumb,oNumb);
            }
        }
        return res;
    }
}
