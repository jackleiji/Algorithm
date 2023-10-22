package jianzhioffer;

import java.util.Arrays;

public class Solution12 {
    public int pivotIndex(int[] nums) {
//        int[] l_to_r = new int[nums.length];
//        int[] r_to_l = new int[nums.length];
//        int l_sum = 0;
//        int r_sum = 0;
//        for(int i=0,j=nums.length-1;i<nums.length;i++,j--){
//            l_sum += nums[i];
//            l_to_r[i] = l_sum;
//            r_sum += nums[j];
//            r_to_l[i] = r_sum;
//        }
//        System.out.println(Arrays.toString(l_to_r));
//        System.out.println(Arrays.toString(r_to_l));
//
//        for(int i=0;i<nums.length-2;i++){
//            if(l_to_r[i]==r_to_l[i+1]){
//                return i;
//            }
//        }
//        return -1;

        //法二，前缀和；
        //总为total，i左和=sum;i右和：total-num[i]-sum ;左和=右和
        int total = Arrays.stream(nums).sum();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(2*sum+nums[i]==total){
                return i;
            }
            sum += nums[i];
        }
        return -1;

    }
}
