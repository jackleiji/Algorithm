package leetcode.solution;

public class Solution45 {
    public int jump(int[] nums) {
        int maxSite = nums[0];
        int len = nums.length;
        int count = 0;
        int end = 0;
        for(int i=0;i<len-1;i++){
            //贪心算法，每次查找最远可以到达的位置
            maxSite = Math.max(nums[i] + i,maxSite);
            if(end==i){
                count++;
                end = maxSite;
            }
        }
        return count;
    }
}
