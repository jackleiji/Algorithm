package interview.ningdeshidai;
import java.util.*;
public class S1 {
    public static void main(String[] args) {
        double[] arr = new double[]{-2.5,4,0,3,0.5,8,-1};
    }

    public double maxProduct(double[] arr) {
        double res = Integer.MIN_VALUE;
        int len = arr.length;
        if(len==0) return 0;
        if(len==1) return arr[0];
        double[] mulMax = new double[len+1];
        double[] mulMin = new double[len+1];
        int i = -1;
        while (++i<len){
            mulMax[i+1] = Math.max(arr[i]*mulMax[i],Math.max(arr[i],arr[i]*mulMin[i]));
            mulMin[i+1] = Math.min(arr[i]*mulMax[i],Math.min(arr[i],arr[i]*mulMin[i]));
            res = Math.max(res,mulMax[i+1]);
        }
        return res;
    }
}
