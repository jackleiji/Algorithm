public class Solution33 {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;

    }
    public int search(int[] nums, int target) {
        // for(int i=0;i<nums.length;i++){
        //     if(target==nums[i]) return i;
        // }
        // return -1;
        //法二
        int mid = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                mid=i;
                break;
            }
        }
        int res = -1;
        if(target==nums[mid]){
            return mid;
        }
        res = binarySearch(nums,0,mid,target);
        if(res!=-1) return res;
        res = binarySearch(nums,mid+1,nums.length-1,target);
        return res;
    }
    //二分查找
    public int binarySearch(int[] nums,int start,int end,int target){
        if(start>end || end<start){ return -1;}

        int mid = (start+end)/2;
        if(target == nums[mid]) return mid;
        if(nums[start]>nums[end]) return -1;
        int res = -1;
        if(nums[mid]>target){
            res = binarySearch(nums,start,mid-1,target);
        }else if(nums[mid]<target){
            res = binarySearch(nums,mid+1,end,target);
        }
        return  res;

    }
}
