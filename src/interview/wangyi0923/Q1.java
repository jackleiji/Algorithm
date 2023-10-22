package interview.wangyi0923;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int j=0;j<t;j++){
            int n = in.nextInt();
            int[] odd = new int[n/2];
            int[] even = new int[n%2==0?n/2:n/2+1];
            int lenOdd = odd.length;
            int lenEven = even.length;
            int lenOddCount = 0;
            int lenEvenCount = 0;
            for(int i=0;i<n;i++){
                if(i%2==1){
                    odd[lenOddCount++] = in.nextInt();
                }else {
                    even[lenEvenCount++] = in.nextInt();
                }
            }
            Arrays.sort(odd);
            Arrays.sort(even);
            System.out.println(Arrays.toString(odd));
            System.out.println(Arrays.toString(even));
            boolean flag = true;
            for(int i=0;i<lenOdd;i++){
                if(lenOdd==lenEven){
                    if(odd[i]<even[i]){
                        flag = false;
                        break;
                    }
                }
                if(lenOdd<lenEven){
                    break;
                }
            }
            System.out.println(flag?"YES":"NO");
        }

    }
}
