package jianzhioffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution4 {
    public int singleNumber(int[] nums) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i : nums){
//            map.put(i,map.getOrDefault(i,0)+1);
//        }
//        Iterator<Map.Entry<Integer,Integer>> entry=map.entrySet().iterator();
//        while (entry.hasNext()){
//            Map.Entry<Integer,Integer> e = entry.next();
//            if(e.getValue()==1) return e.getKey();
//        }
//        return -1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i+=3){
            if(nums[i]!=nums[i+1]) return nums[i];
        }
        return nums[nums.length-1];
    }
}
