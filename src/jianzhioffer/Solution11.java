package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class Solution11 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1}));
    }
    public static int findMaxLength(int[] nums) {
        //暴力超时
//        int res=0;
//        int count = 0;
//        for(int i=0;i<nums.length;i++){
//            int zeroNumb = 0;
//            int oneNumb = 0;
//            int res_temp = res;
//            for(int j=i;j<nums.length;j++){
//                if(nums[j] == 0) zeroNumb++;
//                else if(nums[j]==1) oneNumb++;
////                System.out.println(zeroNumb+" "+oneNumb);
//                if(zeroNumb==oneNumb){
//                    res = Math.max(res,2*zeroNumb);
//                }
//            }
//            if(res_temp<res) count=0;
//            else count++;
//            if (count>=20) return res;
//        }
//        return res;

        //法二：前缀和+哈希表
        int res = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        //从0开始计数
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            int numb = nums[i];
            if(numb==1)count++;
            else count--;
            if(map.containsKey(count)){
                res = Math.max(res,i-map.get(count));
            }else {
                map.put(count,i);
            }
        }
        return res;
    }
}
