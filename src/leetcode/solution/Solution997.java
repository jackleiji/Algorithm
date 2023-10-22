public class Solution997 {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n];
        boolean[] arr_flag = new boolean[n];
        for(int[] human : trust){
            int a = human[0];
            int b = human[1];
            if(a==b) {
                arr[a] = -1;
                continue;
            }
            if(arr[b]!=-1){
                arr[b]++;
                arr_flag[a] = true;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i] == n-1&& !arr_flag[i]) return i;
        }
        return -1;
    }
}
