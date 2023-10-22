package leetcode.meituan.t0902;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "meituan";
        int index = 0;
        int n=in.nextInt();
        int m = in.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = in.next();
        }
        if(n<7){
            System.out.println("NO");
            return;
        }
        for(int i=0;i<n;i++){
            char temp = str.charAt(index);
            for(int j=0;j<m;j++){
                char t = arr[i].charAt(j);
//                System.out.println(index);
                if(t==temp){
                    index++;
                    continue;
                }
            }
            if(index>=7){
                break;
            }
        }
        if(index>=7) System.out.println("YES");
        else System.out.println("NO");
    }
}
//8 2
//nm
//ex
//it
//td
//ul
//qu
//ac
//nt
//8 2
//am
//ex
//it
//td
//ul
//qu
//cc
//dd