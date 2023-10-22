package leetcode.meituan.t0422;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 2, 3};
        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
        int t = 2;
        for(int i=0;i<t;i++){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            nums[i] = scanner.nextInt();
            if(canMakePolyhedron(nums)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }
    public static boolean canMakePolyhedron(int[] nums) {
        int n = nums.length;
        if (n % 2 != 0) {//n不为偶数
            return false;
        }

        return canMakePolyhedron(nums, new int[n / 2], 0);//递归回溯
    }
    //尝试所有的组合
    private static boolean canMakePolyhedron(int[] nums, int[] poly, int idx) {
        if (idx == poly.length) {
            int sum = poly[0] + poly[poly.length - 1];
            System.out.println(sum);
            for (int i = 0; i < poly.length / 2; i++) {
                if (poly[i] + poly[poly.length - i - 1] != sum) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            poly[idx] = nums[i];
            System.out.println(Arrays.toString(poly));
            if (canMakePolyhedron(nums, poly, idx + 1)) {
                return true;
            }
        }
        return false;
    }
}
