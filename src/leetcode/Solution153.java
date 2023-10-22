package leetcode;

public class Solution153 {
    public int findMin(int[] nums) {
        //双指针
        int len = nums.length;
        if(len==1) return nums[0];
        if(nums[0] < nums[len-1]) return nums[0];
        int left = 1;
        int right = len-2;
        while (left<=right){
            if(nums[left]<=nums[right]){
                return Math.min(nums[left],nums[right+1]);
            }
            left++;
            right--;
        }
        return Math.min(nums[--left],nums[++right]);
    }
}
