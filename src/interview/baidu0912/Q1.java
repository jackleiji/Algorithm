package interview.baidu0912;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] arr = new int[n][m];
            if(n==1&&m==1){
                System.out.println("No");
                continue;
            }else if(n==1&&m%2==0){
                System.out.println("Yes");
                continue;
            }else if(n%2==0&&m==1){
                System.out.println("No");
                continue;
            }else if(n%2==0&&m%2==1 || n%2==1&&m%2==0){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
