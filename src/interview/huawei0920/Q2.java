package interview.huawei0920;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Q2 {
//m行 和 n列
//第一列中男生为起点 ，到最后一列男生手里，最优路线（最少次数）
//只能向前后左右
//若不能则放回-1；
//4 4
//1 1 1 0
//1 1 1 0
//0 0 1 0
//0 1 1 1
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] arr = new int[m][n];
        int[] zeroNumb = new int[n];
        boolean flag = false;
        for(int i = 0;i<m;i++){
            for(int j= 0;j<n;j++){
                arr[i][j] = in.nextInt();
                if(arr[i][j] == 0){
                    zeroNumb[j]++;
                    if(zeroNumb[j]==m) flag=true;
                }
            }
        }
        if(flag) System.out.println(-1);
        int res = Integer.MAX_VALUE;
        for(int i = 0;i<m;i++){
            if(arr[i][0]==1){
                boolean[][] flagArr = new boolean[m][n];
                //维护一个二维链表
                LinkedList<Integer[]> list = new LinkedList<>();
                list.add(new Integer[]{i,0});
                flagArr[i][0]=true;
                int site = 0;
                while (!list.isEmpty()){
                    site++;
                    int len = list.size();
                    for(int j=0;j<len;j++){
                        Integer[] siteIndex = list.poll();
//                        System.out.println(siteIndex[0]+" "+siteIndex[1]);
                        if(siteIndex[0]-1>=0&&arr[siteIndex[0]-1][siteIndex[1]]==1 && !flagArr[siteIndex[0]-1][siteIndex[1]]){
                            flagArr[siteIndex[0]-1][siteIndex[1]] = true;
                            list.add(new Integer[]{siteIndex[0]-1,siteIndex[1]});
                        }
                        if(siteIndex[1]-1>=0&&arr[siteIndex[0]][siteIndex[1]-1]==1&& !flagArr[siteIndex[0]][siteIndex[1]-1]){
                            flagArr[siteIndex[0]-1][siteIndex[1]] = true;
                            list.add(new Integer[]{siteIndex[0],siteIndex[1]-1});
                        }
                        if(siteIndex[0]+1<m&&arr[siteIndex[0]+1][siteIndex[1]]==1&& !flagArr[siteIndex[0]+1][siteIndex[1]]){
                            flagArr[siteIndex[0]+1][siteIndex[1]] = true;
                            list.add(new Integer[]{siteIndex[0]+1,siteIndex[1]});
                        }
                        if(siteIndex[1]+1<n&&arr[siteIndex[0]][siteIndex[1]+1]==1&& !flagArr[siteIndex[0]][siteIndex[1]+1]){
                            if(siteIndex[1]+1==n-1){
                                list.clear();
                                res = Math.min(res,site);
                                break;
                            }
                            flagArr[siteIndex[0]][siteIndex[1]+1] = true;
                            list.add(new Integer[]{siteIndex[0],siteIndex[1]+1});
                        }
                    }
                }
            }
        }
        System.out.println(res==Integer.MAX_VALUE?-1:res);
    }
}
