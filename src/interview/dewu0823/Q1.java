package interview.dewu0823;

import java.util.*;

public class Q1 {
    static int res = Integer.MAX_VALUE;
    static boolean[] flag;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//个数
        long m = scan.nextInt();//目标
        int[] arr = new int[n];
        flag = new boolean[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
//        Arrays.sort(arr);
        dfs(arr,0,m,0);
        System.out.println(res==Integer.MAX_VALUE?"No solution":res);
    }
    public static void dfs(int[] arr,int site,long target,int numb){
        if(target<=0 || res <= 2){
            if(target==0){
                res = Math.min(res,numb);
            }
            return;
        }
        for(int i=site;i<arr.length;i++){
            if(!flag[i]){
                flag[i] = true;
                target-=arr[i];
                if(target<0) {
                    flag[i] = false;
                    target+=arr[i];
                }
                dfs(arr,i,target,numb++);
                flag[i] = false;
                target+=arr[i];
            }
        }
    }
}
