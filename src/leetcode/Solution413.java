package leetcode;

public class Solution413 {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,3,5,7,9}));
    }
    public static int numberOfArithmeticSlices(int[] nums) {
//        int n = nums.length;
//        if (n <= 2) {
//            return 0;
//        }
//
//        int d = nums[0] - nums[1], t = 0;
//        int ans = 0;
//        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
//        for (int i = 2; i < n; ++i) {
//            if (nums[i - 1] - nums[i] == d) {
//                ++t;
//            } else {
//                d = nums[i - 1] - nums[i];
//                t = 0;
//            }
//            ans += t;
//        }
//        return ans;
        //求连续等差子串
        int n = nums.length;
        if (n <= 2) {
            return 0;
        }
        int ans = 0,l=0;
        for(int i=2;i<n;i++){
            if((nums[i-2]+nums[i]) == nums[i-1]*2){
                ans += (++l);
            } else {
                l=0;
            }
        }
        return ans;
    }
}
