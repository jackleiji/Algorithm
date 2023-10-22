package leetcode;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        //双指针
        int i,j=0;
        for(i=0;j<nums.length;j++){
            if(nums[i]<nums[j]){
               i++;
               nums[i] = nums[j];
            }
        }
        return i;
    }
}
