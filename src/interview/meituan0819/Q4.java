package interview.meituan0819;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int[] a = new int[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
            sum+=a[i];
        }
        long res = 0;
        int[] b = new int[n];
        //暴力，先求和，每个位置从1开始遍历
        for(int i=0;i<n;i++){
            long temp =sum;
            for(int j=0;j<n;j++){

                for(int k=1;k<sum-n+1;k++){
                    if(k==a[j])
                    b[j] = k;
                }
            }
            if(temp==0){
                res++;
            }
        }
        System.out.println(res%(Math.pow(10,9)+7));
    }
}
