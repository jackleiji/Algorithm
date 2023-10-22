package leetcode.solution;

import java.util.*;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new LinkedList<>();

        List<Integer> res = new LinkedList<>();

        int[][] arr = new int[33][33];
        arr[0][0] = 1;
        arr[1][0] = arr[1][1] = 1;
        for(int i = 2;i<=rowIndex;i++){
            arr[i][0] = arr[i][i] = 1;
            for(int j=1;j<i;j++){
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }

        for(int i=0;i<33;i++){
            if(arr[rowIndex][i] == 0)
                break;
            res.add(arr[rowIndex][i]);
        }
        return res;
    }
    public void dfs(List<List<Integer>> triangle, int rowIndex){
        if(rowIndex == 1){
            List<Integer> data_tri = new LinkedList<>();
            data_tri.add(1);
            data_tri.add(1);
            triangle.add(data_tri);
            return;
        }else {
            dfs(triangle,rowIndex--);
//            triangle.get(rowIndex);
//            List<Integer> data_tri = new LinkedList<>();
//            for(int i=1;i<rowIndex;i++){
//                data_tri.add(i,);
//            }
        }
    }
}
