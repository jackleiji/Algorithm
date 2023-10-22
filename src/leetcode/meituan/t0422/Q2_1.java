package leetcode.meituan.t0422;

import java.util.Arrays;
import java.util.Scanner;

public class Q2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;i++){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int j=0;j<n;j++){
                nums[j] = scanner.nextInt();
            }
            Arrays.sort(nums);
            if(checkArr(nums)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
    public static boolean checkArr(int[] nums) {
        int n = nums.length;
        if (n % 2 != 0) {//n不为偶数
            return false;
        }
        int value = nums[0]+nums[nums.length-1];
        for(int i=1,j=nums.length-2;i<nums.length;i++,j--){
            if(nums[i]+nums[j]!=value){
                return false;
            }
        }
        return true;
    }

}
