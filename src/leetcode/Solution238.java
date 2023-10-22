package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,1,0,1,1})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int mul = 1;
        int zero_before = 1;
        boolean flag = false;
        LinkedList<Integer> site = new LinkedList<>();
        for(int i=0;i<len;i++){
            if(nums[i] == 0){
                flag=true;
                site.add(i);
                if(flag && site.size()==1){
                    zero_before = mul;
                }
            }
            if(flag && site.size()>=2){
                Arrays.fill(res,0);
                return res;
            }
            mul *= nums[i];
        }

        if(flag && site.size()==1){
            Arrays.fill(res,0);
            int index = site.get(0);
            for(int i=index+1;i<len;i++){
                zero_before *= nums[i];
            }
            res[index] = zero_before;
            return res;
        }
        //无0
        for(int i=0;i<len;i++){
            res[i] = mul/nums[i];
        }
        return res;
    }
}
