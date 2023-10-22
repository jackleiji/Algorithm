package interview.ningdeshidai;
import java.util.*;
public class S3 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        System.out.println(maxXOR(arr));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型
     */
    public static int maxXOR (ArrayList<Integer> array) {
        // write code here
        int len = array.size();
        if(len==2) return array.get(0)^array.get(1);
        int res = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                res = Math.max(res,array.get(i)^array.get(j));
            }
        }
        return res;
    }
}
