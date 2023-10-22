package leetcode;

import java.util.Arrays;

public class Solution300 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len==1) return 1;
        int[] flag = new int[len];
        flag[0] =1;
        int res = 1;
        for(int i=1;i<len;i++){
            int site = compare(nums,flag,nums[i],i);
            if(site!=-1){
                flag[i] = flag[site]+1;
                res = Math.max(flag[i],res);
                continue;
            }
            flag[i] = 1;
        }
        System.out.println(Arrays.toString(flag));
        return res;
    }
    public static int compare(int[] nums,int[] flag,int target,int bound){
        int res = -1;
        int max = 1;
        for(int i=bound-1;i>=0;i--){
            if(nums[i]<target && flag[i]>=max){
                max=flag[i];
                res = i;
            }
        }
        return res;
    }
}
