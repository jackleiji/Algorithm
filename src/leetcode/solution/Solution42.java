package leetcode.solution;

public class Solution42 {
    public int trap(int[] height) {
//        int res=0;
//        int len = height.length;
//        int leftMax = 0;
//        int rightMax = 0;
//        for(int i=0;i<len;i++){
//            rightMax = Math.max(height[i],rightMax);
//        }
//        for(int i=0;i<len;i++){
//            int temp = height[i];
//            if(temp>leftMax) leftMax=temp;
//            res += (Math.min(leftMax,rightMax) - temp);
//            // System.out.println(leftMax+" "+rightMax+" "+res);
//            //更新右值
//            if(rightMax==temp){
//                rightMax = 0;
//                for(int j=i+1;j<len;j++){
//                    rightMax = Math.max(height[j],rightMax);
//                }
//            }
//        }
//        return res;
        //动态规划
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1, j = n - 2; i < n; ++i,--j) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}