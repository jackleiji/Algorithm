package interview.baidu0912;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        int[] kSite = new int[k];
        boolean[] flag = new boolean[k];
        int count = 0;
        for(int i=0;i<n;i++){
            int temp = in.nextInt();
            if(temp<=k && !flag[temp-1]){
                kSite[temp-1] = i;
                flag[temp-1] = true;
                count++;
            }
            arr[i] = temp;
        }
        if(count<k){
            System.out.println("NO");
            return;
        }
        int indexInArrData = Integer.MAX_VALUE;
        int indexOurArrData = Integer.MAX_VALUE;
        int res = 0;
        for(int i=1;i<k;i++){
            if(kSite[i]-kSite[i-1]==1){
                continue;
            }
            if(i+1<k&&kSite[i+1]-kSite[i-1]==2){
                indexInArrData = kSite[i]+1;
                indexOurArrData = i+1;
                res++;
                break;
            }else {
                indexInArrData = kSite[i-1]+1;
                indexOurArrData = i;
                res++;
                break;
            }
        }
        System.out.println("YES");
        System.out.println(res);
        if(res==1){
            System.out.println(Math.min(indexInArrData,indexOurArrData));
            System.out.println(Math.max(indexInArrData,indexOurArrData));
        }

    }
}
