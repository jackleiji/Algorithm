package leetcode;

import java.util.Arrays;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
        return nums[k];
    }
    public void quickSort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int mid = (left + right) / 2;
        while (l < r) {
            while (nums[l] < nums[mid]) { // 将 '<' 修改为 '>'
                l++;
            }
            while (nums[r] > nums[mid]) { // 将 '>' 修改为 '<'
                r--;
            }
            if (l >= r)
                break;
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            if (nums[l] == nums[mid]) {
                r--;
            }
            if (nums[r] == nums[mid]) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (l < right) {
            quickSort(nums, l, right);
        }
        if (left < r) { // 将 'left < r' 修改为 'left < r'
            quickSort(nums, left, r);
        }
    }

}
