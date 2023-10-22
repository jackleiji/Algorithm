package leetcode.solution;
import java.util.*;

public class Solution287 {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i =0,j=nums.length-1;i<nums.length/2;i++,j--){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
            if(set.contains(nums[j])){
                return nums[j];
            }
            set.add(nums[j]);
        }
        return -1;
    }
}
