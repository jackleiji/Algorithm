package leetcode.solution;

import java.util.Arrays;

public class Solution55 {
    public boolean canJump(int[] nums) {
        int maxSite = 0;
        int len = nums.length;
        for(int i=0;i<len-1;i++){
            maxSite = Math.max(maxSite,nums[i]+i);
            if(maxSite>=len-1) return true;
            if(maxSite<=i){
                return false;
            }
        }
        return  true;
    }
}

