package interview.meituan0819;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==1) {
            System.out.println(in.nextInt());
            return;
        }
        long[] arr = new long[n];
        long maxMul = 0;
        int rightNumbSite = 0;
        long res = 0;
        for(int i=0;i<n;i++){
            if(i==0){
                arr[i] = in.nextInt();
            }else {
                arr[i] = in.nextInt();
                long mul = arr[i]*arr[i-1];
                if(mul>maxMul){
                    rightNumbSite =i;
                    maxMul = mul;
                }
            }
            res += arr[i];
        }
        System.out.println(res-arr[rightNumbSite]-arr[rightNumbSite-1]+maxMul);

    }
}
