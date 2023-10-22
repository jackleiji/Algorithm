package interview.dewu0823;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        //贪心算法。每次取最有，节点通路是相互的构造矩阵
        int[][] arr = new int[n][n];
        for(int[] i:arr)
            Arrays.fill(i,-1);
        for(int i=0;i<m;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int value = scan.nextInt();
            arr[a-1][b-1] = value;
            arr[b-1][a-1] = value;
        }

        //1从开始遍历
        long maxRes = 0;
        for(int k = 0;k<n;k++){
            int nodeSite = k;
            boolean[] flag = new boolean[n];
            flag[nodeSite] = true;
            long res = 0;
            while (nodeSite!=-1){
                int data = 0;
                int temp = nodeSite;
                for(int i=0;i<n;i++){
                    if(!flag[i] && arr[temp][i] > data){
                        nodeSite = i;
                    }
                }
                if(nodeSite == temp) {
                    break;
                }
                flag[nodeSite] = true;
                res += arr[temp][nodeSite];
            }
            maxRes = Math.max(maxRes,res);
        }

        System.out.println(maxRes==0?"No Solution":maxRes);
    }
}
