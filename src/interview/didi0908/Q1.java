package interview.didi0908;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            max = Math.max(arr[i],max);
        }
        int res = (b/max)*(a/arr.length);
        while (true){
            int temp = 0;
            for(int i=0;i<n;i++){
                temp += (arr[i]*res)/b;
            }
            System.out.println(temp);
            if(temp>=a){
                break;
            }
            if(temp-a>10){
                res++;
            }
            res++;
        }
        System.out.println(res);
    }
}
