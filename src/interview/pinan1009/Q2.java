package interview.pinan1009;

public class Q2 {
    public int[] printNumbers (int n) {
        // write code here
        long len = (long) Math.pow(10,2);
        int[] res = new int[(int)len];
        System.out.println(10^n);
        for(int i = 0;i<len;i++){
            res[i] = i+1;
        }
        return res;
    }
}
