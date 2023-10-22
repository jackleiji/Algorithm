package leetcode;

import java.util.Arrays;

public class Solution213 {
    public int rob(int[] nums) {
        return Math.max(
                dp(Arrays.copyOfRange(nums,0,nums.length-1)),
                dp(Arrays.copyOfRange(nums,1,nums.length))
        );
    }
    //动态规划算法
    public int dp(int[] nums){
        int len = nums.length;
        int[] arr = new int[len+1];
        arr[1] = nums[0];
        for(int i=2;i<=len;i++){
            arr[i] = Math.max(nums[i-1],arr[i-1]+nums[i-2]);
            System.out.println(Arrays.toString(arr));
        }
        return arr[len];
    }
}
