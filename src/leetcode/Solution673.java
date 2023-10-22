package leetcode;

public class Solution673 {
    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{2,2,2,2,2}));
    }
    public static int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if(len<2) return 1;
        int[] flag = new int[len];
        int[] count = new int[len];
        int maxLen = 0;
        int ans = 0;
        for(int i=0;i<len;i++){
            flag[i] =1;
            count[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(flag[i]<flag[j]+1){
                        flag[i]=flag[j]+1;
                        count[i] = count[j];
                    }else if(flag[i]==flag[j]+1){
                        count[i]+=count[j];
                    }
                }
            }
            if(maxLen<flag[i]){
                maxLen = flag[i];
                ans = count[i];
            }else if(maxLen==flag[i]){
                ans += count[i];
            }
        }
        return ans;
    }
}
