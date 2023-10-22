package jianzhioffer;

import java.util.*;
import java.util.stream.Collectors;

public class Solution7 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {-1,0,0};
        threeSum(nums);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        //三元数组，和为0，且一个三元数组中不包含同位置的元素
        List<List<Integer>> res = new ArrayList<>();
        //排序数组
        Arrays.sort(nums);
        int len = nums.length-1;
        //最小值大于0或最大值小于0 退出
        if(nums[0] > 0 || nums[len]<0){
            return res;
        }
        //暴力算法,超时
        for(int left=0;left<=len-2;left++){
            if(nums[left]>0) break;
            if(left>0&&nums[left-1]==nums[left]) continue;
            //
            for(int next = left+1;next<=len-1;next++){
                int target = -(nums[left] + nums[next]);
                if(next>left+1&&nums[next-1]==nums[next]) continue;
//                System.out.println(nums[left]+" "+nums[next]+" "+target);
                //二分查找
                int l = next+1;
                int r = len;
                if(nums[l]>target||nums[r]<target) continue;
                while (l<=r){
                    int mid = (l+r)/2;
                    if(nums[mid] == target){
                        List<Integer> temp =Arrays.asList(nums[left],nums[next],nums[mid]);
//                        if(!res.contains(temp)){
                            res.add(new ArrayList<>(temp));
                            System.out.println(temp.toString());
//                        }
                        break;
                    }else if(nums[mid] < target){
                        l=mid+1;
                    }else {
                        r=mid-1;
                    }
                }
            }
        }

        return res;

    }
}
