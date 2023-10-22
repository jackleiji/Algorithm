import java.util.Arrays;

public class Solution130 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(m==1&&n==1) return;
        boolean[][] board_flag = new boolean[m][n];
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O' && !board_flag[i][j]){
                    dfs(board,board_flag,i,j);
                    if(!flag){
                        dfs_change(board,i,j);
                    }
                }
                flag=false;
            }
        }



    }
    boolean flag = false;
    public void dfs(char[][] board,boolean[][] board_flag,int x,int y){
        if(x>board.length-1 || y>board[0].length-1 || x<0 || y<0 || board_flag[x][y]){
            flag = true;
            return;
        }
        if(board_flag[x][y] || board[x][y] !='O') return;
        board_flag[x][y] = true;
        dfs(board,board_flag,x+1,y);
        dfs(board,board_flag,x-1,y);
        dfs(board,board_flag,x,y+1);
        dfs(board,board_flag,x,y-1);
    }
    public void dfs_change(char[][] board,int x,int y){
        if(flag || x>board.length-1 || y>board[0].length-1 || x<0 || y<0){
            return;
        }
        if(board[x][y] !='O') return;
        board[x][y] ='X';
        dfs_change(board,x+1,y);
        dfs_change(board,x-1,y);
        dfs_change(board,x,y+1);
        dfs_change(board,x,y-1);
    }
}
