package leetcode;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        //动态规划
        //先考虑输出false的情况，sum(nums) 为奇数时，输出false；
        //记录数组中的最大值，若sum(nums)/2小于最大值时，输出false；
        //构造dp[n][target+1]的数组，构造状态方程
        //当j<numb[i] : dp[i-1][j];当j>=numb[i] : dp[i-1][j-numb[i]]|dp[i-1][j];
        int len = nums.length;
        int sum = 0;
        int maxNumb = 0;
        for(int i=0;i<len;i++){
            sum+=nums[i];
            maxNumb = Math.max(nums[i],maxNumb);
        }
        if(sum%2==1) return false;
        int target = sum/2;
        if(maxNumb > target) return false;
        boolean[][] dp = new boolean[len][target+1];
        dp[0][nums[0]] = true;
        for(int i=1;i<len;i++){
            for(int j=0;j<target+1;j++){
                if(j == 0){
                    dp[i][j] = true;
                    continue;
                }
                if(j<nums[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i]];
                }
            }
        }

        return dp[len-1][target];
    }
}
