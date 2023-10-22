package jianzhioffer;

public class NumMatrix {
    int[][] pre_matrix;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        //遍历二维矩阵，生成前缀矩阵
        pre_matrix = new int[matrix.length][matrix[0].length];

        this.matrix = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            int sum=0;
            for(int j=0;j<matrix[0].length;j++){
                sum+=matrix[i][j];
                this.matrix[i][j] = matrix[i][j];
                pre_matrix[i][j] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1;i<=row2;i++){
            sum += pre_matrix[i][col2]-pre_matrix[i][col1]+matrix[i][col1];
        }
        return sum;
    }
}
