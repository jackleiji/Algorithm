package interview.qunaer0915;

public class Q2 {
    public int minPath (int[][] paths) {
        // write code here
        int res = 0;
        int n = paths.length;
        int m = paths[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j!=0){
                    paths[i][j] = paths[i][j-1]+paths[i][j];
                }else if(j==0 && i!=0){
                    paths[i][j] = paths[i-1][j]+paths[i][j];
                }else if(i!=0){
                    paths[i][j] = Math.min(paths[i-1][j],paths[i][j-1])+paths[i][j];
                }
            }
        }

        return paths[n-1][m-1];
    }
}
