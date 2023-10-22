public class Solution34 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(binarySearch(arr,-1));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums.length==0) return res;
        int site = binarySearch(nums,target);
        int left = site-1;
        int right = site+1;
        if(site == -1) return res;
        else {
            while (left>=0 && nums[left] == target){
                left--;
            }
            while (right<nums.length&&nums[right] ==target){
                right++;
            }
        }

        return new int[]{left+1,right-1};
    }
    public static int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = (left+right)/2;
            if (target == nums[mid]) return mid;
            else if(target>nums[mid]) left = mid+1;
            else if(target<nums[mid]) right = mid-1;
        }
        return -1;
    }
}
