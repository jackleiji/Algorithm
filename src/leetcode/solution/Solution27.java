package leetcode.solution;

import java.util.Arrays;

public class Solution27 {
    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(removeElement(nums,2));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeElement(int[] nums, int val) {
        //双指针
        int index_pre = 0;
        int index_last = 0;
        while (index_last<nums.length){
            if(nums[index_pre] != val){
                if(index_pre==index_last){
                    index_pre++;
                    index_last++;
                }else {
                    index_pre++;
                }
            }else {
                while (index_last<nums.length && nums[index_last]==val){
                    index_last++;
                }
                //交换位置数据
                if(index_last<nums.length){
                    int temp = nums[index_pre];
                    nums[index_pre] = nums[index_last];
                    nums[index_last] = temp;
                }
            }
        }
        return index_pre;
    }
}
