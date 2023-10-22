import java.util.*;

public class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        if(grid[0][0]!= 0|| grid[len-1][len-1]!=0) return -1;
        if(len==1 && grid[0][0]== 0) return 1;
        //广度优先遍历
        int[][] dirs ={{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        int res = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()){
            res++;
            int size = queue.size();
            for(int i = 0;i<size;i++){
                if(queue.isEmpty()) continue;
                int[] site = queue.poll();
                if(site[0]==len-1 && site[1]==len-1) return res;
                for(int[] dir : dirs){
                    int row = site[0]+dir[0];
                    int column = site[1]+dir[1];
                    if(row<0||row>len-1||column<0||column>len-1) continue;
                    if(grid[row][column]==0){
                        grid[row][column] = 1;
                        queue.add(new int[]{row,column});
                    }
                }
            }
        }
        return -1;
    }
}
