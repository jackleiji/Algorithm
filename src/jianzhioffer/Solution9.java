package jianzhioffer;

public class Solution9 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{1,2,3},0));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int sum = 1;
            for(int j=i;j<nums.length;j++){
                sum *= nums[j];
                if(sum>=k){
                    break;
                }
                res++;
            }
        }
        return res;
    }
}
