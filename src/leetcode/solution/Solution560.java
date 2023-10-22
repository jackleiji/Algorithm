package leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution560 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,1,2,1},3));
    }
    public static int subarraySum(int[] nums, int k) {
//        return dfs(nums,k,0);
        //法二：前缀+hashmap
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                res += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
    private static int dfs(int[] nums, int k, int i) {
        if (i >= nums.length) {
            return 0;
        }
        int count = 0;
        int sum = 0;
        for (int j = i; j < nums.length; j++) {
            sum += nums[j];
            if (sum == k) {
                count++;
            }
        }
        return count + dfs(nums, k, i + 1);
    }
}
