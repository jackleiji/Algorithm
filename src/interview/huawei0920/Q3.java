package interview.huawei0920;

import java.util.LinkedList;

public class Q3 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,1,1,0},{1,0,0,1},{1,0,0,0},{0,1,0,0}};
        int[] color = new int[]{2,1,2,3};
        for(int i=0;i<arr.length;i++){
            System.out.println(bfs(arr,color,i));
        }

    }
    //0:0 1 1 0
    //1:1 0 0 1
    //2:1 0 0 0
    //3:0 1 0 0
    public static int bfs(int[][] arr,int[] color,int site){
        int len=arr.length;
//        boolean[][] flag = new boolean[len][len];
        boolean[] flag =  new boolean[len];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<len;i++){
            if(arr[site][i] == 1){
                if(color[site]==color[i]) {
                    return 1;
                }
                list.add(i);
            }
        }
        flag[site]= true;
        int count = 0;
        while (!list.isEmpty()){
            int lenList = list.size();
            count++;
            for(int i=0;i<lenList;i++){
                int temp = list.poll();
//                System.out.println(temp);
                for(int j=0;j<len;j++){
                    if(arr[temp][j]==1&&!flag[j]){
                        list.add(j);
                        if(color[site]==color[j]) {
                            return ++count;
                        }
                    }
                }
                flag[temp] = true;
            }
        }
        return -1;
    }
}
