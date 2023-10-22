package jianzhioffer;

import java.util.*;

public class Solution10 {
    public int subarraySum(int[] nums, int k) {
        //滑动指针，数字和大于target时，left左移
//        int res = Integer.MAX_VALUE;
//        for(int i=0;i<nums.length;i++){
//            int sum = 0;
//            for(int j=i;j<nums.length;j++){
//                sum +=nums[j];
//                if(sum==k) {
//                    res = Math.min(j-i,res);
//                }else if(sum>k){
//                    break;
//                }
//            }
//        }
//        return res==Integer.MAX_VALUE?0:res+1;

        //法二前缀和+哈希表
        int count = 0;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            count += nums[i];
            if(map.containsKey(count-k)){
                res += map.get(count-k);
            }
            map.put(count,map.getOrDefault(count,0)+1);
        }
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> m = iterator.next();
            System.out.println(m.getKey()+" "+m.getValue());
        }


        return res;
    }
}
