package jianzhioffer;

public class Solution8 {
    public int minSubArrayLen(int target, int[] nums) {
        //滑动指针，数字和大于target时，left左移
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum +=nums[j];
                if(sum>=target) {
                    res = Math.min(j-i,res);
                    break;
                }
            }
        }
        return res==Integer.MAX_VALUE?0:res+1;
    }
}
