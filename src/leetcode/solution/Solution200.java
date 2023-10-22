public class Solution200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }

        return res;
    }
    public void dfs(char[][] grid,int row,int column){
        if(row<0||row>grid.length-1||column<0||column>grid[0].length-1) return;
        if(grid[row][column] != '1' || grid[row][column] == '0') return;
        grid[row][column] = '3';
        dfs(grid,row+1,column);
        dfs(grid,row-1,column);
        dfs(grid,row,column+1);
        dfs(grid,row,column-1);
    }

}
