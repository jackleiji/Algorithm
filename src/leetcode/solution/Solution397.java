import java.math.BigInteger;

public class Solution397 {
    public static void main(String[] args) {
        System.out.println(integerReplacement(2147483647));
    }
    static int integerReplacement(int n) {
        if(n==1) return 0;
        if(n == 2147483647) return 32;
        int count = 0;
        while (n!=1){
            count++;
            if(n%2==0){
                n/=2;
            }else if(n%2==1){
                if(n>3 && n%4!=1){
                    n = n+1;
                }else {
                    n=n-1;
                }

            }
            System.out.println(n);
            if(n<=0) break;
        }

        return count;
    }
    public long func(long n){
        if(n ==1) return 0;
        if(n%2==0){
            return  1 + func(n/2);
        }else  {
            return 1 + Math.min(func(n+1),func(n-1));
        }
    }
}
