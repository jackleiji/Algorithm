package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution239 {
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,-1},1);
    }
    //优先级队列
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0] ? o2[0]-o1[0] : o2[1]-o1[1];
            }
        });
        int [] res = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            pq.offer(new int[]{nums[i], i});
        }
        res[0] = pq.peek()[0];
        for(int i=k;i<nums.length;i++){
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1]<=i-k){
                pq.poll();
            }
            res[i-k+1] = pq.peek()[0];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
    //超时
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        System.out.println(nums.length);
//        if(nums.length==1) return nums;
//        int[] res = new int[nums.length-k+1];
//        int max = Integer.MIN_VALUE;
//        int effect = 0;
//        for(int i=0;i<nums.length;i++){
//            int temp = nums[i];
//            if(i<k-1){
//                if(temp>=max){
//                    max = temp;
//                    effect = k;
//                }
//                effect--;
//                continue;
//            }
//            if(temp>=max){
//                max = temp;
//                effect = k;
//            }
//            if(effect<=0){
//                effect = findEffect(Arrays.copyOfRange(nums,i-k+1,i+1));
//                max = nums[i-k+1+effect];
//            }
//            res[i-k+1] = max;
//            effect--;
//        }
//        return res;
//    }
//    public static int findEffect(int[] nums){
//        int maxSite = 0;
//        int maxNumb = Integer.MIN_VALUE;
//        for(int i=0;i<nums.length;i++){
//            int temp = nums[i];
//            if(temp>maxNumb){
//                maxSite = i;
//                maxNumb = temp;
//            }
//        }
//        return maxSite;
//    }
}

