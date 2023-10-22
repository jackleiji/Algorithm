public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            int sum = nums[i];
            int end = i+1;
            while (sum<k){
                res++;
                if(end<len){
                    sum*=nums[end++];
                }else {
                    break;
                }
            }

        }
        return res;
    }
}
