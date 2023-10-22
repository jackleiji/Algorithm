package leetcode.solution;

import java.util.*;

public class Solution79 {
    public static void main(String[] args) {
//        System.out.println(exist(new char[][]{
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}},"SEE"));
        System.out.println(exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}} ,"ABCESEEEFS"));
    }
    static boolean flag;
    public static boolean exist(char[][] board, String word) {
        flag = false;
        int m=board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(board[i][j]==word.charAt(0)){
                    boolean[][] boardFlag = new boolean[m][n];
//                        boardFlag[i][j] = true;
                    dfs(board,boardFlag,word,i,j,0);
                }
                if(flag) return true;
            }
        }
        return false;
    }
    public static void dfs(char[][] board,boolean[][] boardFlag,String word,int x,int y,int site){
        if(site==word.length()){
            flag=true;
            return;
        }
        if(x<0||y<0||x>=board.length||y>=board[0].length||board[x][y]!=word.charAt(site)||boardFlag[x][y]){
            return;
        }
        boardFlag[x][y] = true;
        dfs(board,boardFlag,word,x+1,y,site+1);
        dfs(board,boardFlag,word,x-1,y,site+1);
        dfs(board,boardFlag,word,x,y+1,site+1);
        dfs(board,boardFlag,word,x,y-1,site+1);
        boardFlag[x][y] = false;
    }
}
