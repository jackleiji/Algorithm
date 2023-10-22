package interview.zhongguoyidong1015;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] arr = new long[n][2];
        long[] MaxArr = new long[n];
        long maxN = 0;
        long maxPain = 0;
        arr[0][0] = in.nextLong();
        arr[0][1] = in.nextLong();
        MaxArr[0] = arr[0][1];
        maxPain = arr[0][0];

        for(int i=1;i<n;i++){
            arr[i][0] = in.nextLong();
            arr[i][1] = in.nextLong();
            MaxArr[i] = Math.max(MaxArr[i-1],arr[i][1]);
            maxN = Math.max(maxN,arr[i][1]);
        }
//        for(long[] a : arr){
//            System.out.println(Arrays.toString(a));
//        }
        long q = in.nextInt();
        for(long i =0;i<q;i++){
            long res = -1;
            long pain = in.nextLong();
            for(int j = 0;j<n;j++){
                if(arr[j][0]<=pain){
                    res = Math.max(res,arr[j][1]);
                }
                if(res == maxN ||arr[j][0]>pain){
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
