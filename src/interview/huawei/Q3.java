package interview.huawei;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();//微服务个数
        int n = scan.nextInt();//节点联通数
        int[][] arr = new int[m][m];
        for(int i=0;i<n;i++){
//            String data = scan.nextLine();
            int[] site = new int[3];
            site[0] = scan.nextInt();
            site[1] = scan.nextInt();
            site[2] = scan.nextInt();
            arr[site[0]-1][site[1]-1] = site[2];
        }
        int srcService = scan.nextInt();
        //迪杰斯特拉求最短路径问题
        //创建状态表和距离表
        boolean[] state = new boolean[m];
        state[srcService-1] = true;
        int[] dir = new int[m];
        int startNode = srcService-1;
        while (startNode!=-1){
            int node = startNode;
            System.out.println(node);
            state[node] = true;
            for(int i=0;i<m;i++){
                if(arr[node][i] != 0 && !state[i]){
                    if(dir[i]==0)
                        dir[i] = dir[node]+arr[i][i]+arr[node][i];
                    else{
                        dir[i] = Math.min(dir[node]+arr[i][i]+arr[node][i],dir[i]);
                    }
                }
            }
            System.out.println(Arrays.toString(dir));
            int site = -1;
            int min_S = Integer.MAX_VALUE;
            for(int i=0;i<m;i++){
                if(!state[i] && dir[i]!=0){
                    if(dir[i]<min_S){
                        min_S=dir[i];
                        site = i;
                    }
                }
            }
            if(site!=-1)
                startNode = site;
            else startNode = -1;
        }
        int resNumb = 0;
        int minRoad = 0;
        for(int i=0;i<m;i++){
            if(dir[i]!=0){
                resNumb++;
                minRoad = Math.max(dir[i],minRoad);
            }
        }
        System.out.println((resNumb+1)+" "+minRoad);
    }
}
