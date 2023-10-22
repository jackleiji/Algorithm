package leetcode;

import java.util.Arrays;

public class Solution59 {
    public static void main(String[] args) {
        int[][] res = generateMatrix(2);

        for(int i=0;i<4;i++){
            System.out.println(Arrays.toString(res[i]));
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row = 0;
        int col = 0;
        int bound_left = 0;
        int bound_right = n-1;
        int bound_up = 1;
        int bound_down = n-1;
        int numb = 1;
        int site = 0;
        while (numb<=n*n){
            res[row][col] = numb;
            if(site == 0){
                col++;
                if(col>=bound_right){
                    col = bound_right;
                    bound_right -=1;
                    site=1;
                }
            }else if(site == 1) {
                row++;
                if(row>=bound_down){
                    row = bound_down;
                    bound_down -=1;
                    site=2;
                }
            }else if(site == 2) {
                col--;
                if(col<=bound_left){
                    col = bound_left;
                    bound_left +=1;
                    site=3;
                }
            }else if(site == 3) {
                row--;
                if(row<=bound_up){
                    row = bound_up;
                    bound_up +=1;
                    site=0;
                }
            }
            numb++;
        }
        return res;
    }
}
