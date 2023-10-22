package leetcode.solution;

import java.util.*;

public class Solution169 {
    public int majorityElement(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums.length <=1){
            return nums[0];
        }
        //法一
//        int count_res = 0;
//        int numb_res = 0;
//        int count = 0;
//        for (int numb:nums) {
////            System.out.println(count);
//            if (map.containsKey(numb)){
//                count = map.get(numb);
//                if(count_res<count){
//                    count_res = count;
//                    numb_res = numb;
//                    System.out.println(numb_res);
//                }
//                map.put(numb,count+1);
//                continue;
//            }
//            map.putIfAbsent(numb,1);
//
//        }
//        System.out.println(map.toString());
        // 发二：
        Arrays.sort(nums);

        return nums[nums.length/2];
    }
}
