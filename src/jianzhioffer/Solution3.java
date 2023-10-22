package jianzhioffer;

public class Solution3 {
//    public int[] countBits(int n) {
//        int[] res = new int[n+1];
//        for(int i=1;i<=n;i++){
//            res[i] = countOne(i);
//        }
//        return res;
//    }
//    public int countOne(int numb){
//        int count = 0;
//        while (numb>0){
//            numb &= (numb-1);
//            count++;
//        }
//        return count;
//    }
    //动态规划+位运算
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=1;i<=n;i++){
            res[i] = res[i>>1]+(i&1);
        }
        return res;
    }
}
