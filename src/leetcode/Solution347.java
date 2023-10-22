package leetcode;

import java.util.*;

public class Solution347 {
    public static void main(String[] args) {
        topKFrequent(new int[]{1},1);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        //定义优先队列
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        queue.addAll(map.entrySet());
        int[] ans = new int[k];
        for (int i = 0; i < k && !queue.isEmpty(); ++i){
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }
}
