package leetcode.solution;

import java.util.Arrays;

public class Solution152 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-4,-3}));
    }
    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        //动态规划，
        //思路：设计最大最小值2个数组，目的是使得保存到当前位置时的最大最小值，
        //即当前位置为正数，或负数时都能获得当前位置能够取得的最大最小结果。
        //最大连续和即保存在最大数组中。
        int len = nums.length;
        if(len==1) return nums[0];
        int[] numsMax = new int[len+1];
        int[] numsMin = new int[len+1];
        for(int i=0;i<len;i++){
            numsMax[i+1] = Math.max(nums[i]*numsMax[i],Math.max(nums[i],numsMin[i]*nums[i]));
            numsMin[i+1] = Math.min(nums[i]*numsMax[i],Math.min(nums[i],numsMin[i]*nums[i]));
            res = Math.max(res,numsMax[i]);
        }
        System.out.println(Arrays.toString(numsMax));
        return res;
    }
}
