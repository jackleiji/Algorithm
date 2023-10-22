package leetcode;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if(nums.length==2) return nums[0]>nums[1]?0:1;
        else if(nums[0]>nums[1]) return 0;
        else if(nums[-1]>nums[-2]) return nums.length-1;
        int len = nums.length;
        //定义2个大小为3的滑动窗口
        int res = 0;
        int left1 = 0;
        int left2 = 1;
        int left3 = 2;

        int right1 = len-1;
        int right2 = len-2;
        int right3 = len-3;

        while (left1<len-3 && right1>1 && left1<right1){
            if(nums[left1]<nums[left2]&&nums[left2]>nums[left3]){
                return left2;
            }
            if(nums[right1]<nums[right2]&&nums[right2]>nums[right3]){
                return right2;
            }
            left1++;left2++;left3++;
            right1--;right2--;right3--;
        }

        return -1;
    }
}
