package jianzhioffer;

public class Solution6 {
    public int[] twoSum(int[] numbers, int target) {
        //双指针，排序数组
        //和>target 右指针左移，和<target 左指针右移

        int left = 0;
        int right = numbers.length-1;
        int sum = numbers[left]+numbers[right];
        while (sum!=target){
            if(sum<target){
                left++;
            }else {
                right--;
            }
            sum = numbers[left]+numbers[right];
        }
        return new int[]{left,right};
    }
}
