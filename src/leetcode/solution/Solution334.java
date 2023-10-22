package leetcode.solution;

public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for(int i:nums){
            if(small>= i){
                small = i;
            }else if(mid>=i){
                mid = i;
            }else{
                return true;
            }
        }
        return false;
    }
}
