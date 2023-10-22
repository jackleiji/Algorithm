package leetcode.solution;

import java.util.Arrays;

public class Solution48 {
    public static void main(String[] args) {
        int[][] matrix = {{1}};
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
    public static void rotate(int[][] matrix) {
        int len = matrix.length ;
        int cir = len;
        int layer_start = 0;
        int layer_end = len-1;
        while (cir >1){
            for(int i=layer_start,j=layer_end;i<layer_end;i++,j--){
                //循环换位
                int temp = matrix[layer_start][i];
                matrix[layer_start][i] = matrix[j][layer_start];
                matrix[j][layer_start] = matrix[layer_end][j];
                matrix[layer_end][j] = matrix[i][layer_end];
                matrix[i][layer_end] = temp;
            }
            layer_start++;
            layer_end--;
            cir -= 2;
        }

    }
}
