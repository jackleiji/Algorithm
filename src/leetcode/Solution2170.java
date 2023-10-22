package leetcode;

public class Solution2170 {
    public static void main(String[] args) {
//        System.out.println(minimumOperations(new int[]{11,84,94,79,63,59,95,93,3,23,25,21,31,97,29,83,6,91,81,57,60,92,52,87,40,97,41,4,89,55,46,81,14,22,11,92,2,39,81,85,25,21,88,26,14,11,21,71,83,52,74,77,32,8,56,30,88,54,43,71,60,61,96,25,10,10,9,84,85}));
        System.out.println(minimumOperations(new int[]{4,4,4,4,3,4}));
    }
    public static int minimumOperations(int[] nums) {
        //贪心算法
        //遍历数组，查看奇偶数组中最多的元素个数
//        int len = nums.length;
//        if(len<=1)return 0;
//        Map<Integer,Integer> evenMap = new HashMap<>();
//        Map<Integer,Integer> oddMap = new HashMap<>();
//        int evenMax = -1;
//        int evenData = -1;
//        int oddMax = -1;
//        int oddData = -1;
//        for(int i=0;i<len;i++){
//            if(i%2==0){
//                Integer data = evenMap.getOrDefault(nums[i],0)+1;
//                evenMap.put(nums[i],data);
//                if(data>evenMax){
//                    evenMax = data.intValue();
//                    evenData = nums[i];
//                }
//            }else {
//                Integer data = oddMap.getOrDefault(nums[i],0)+1;
//                oddMap.put(nums[i],data);
//                evenMap.put(nums[i],data);
//                if(data>oddMax){
//                    oddMax = data.intValue();
//                    oddData = nums[i];
//                }
//            }
//        }
//        System.out.println(oddData+" "+evenData);
//        int res =0;
//        for(int i=0;i<len;i++){
//            if(i%2==0){
//                res += nums[i] == evenData? 0:1;
//            }
//            else {
//                res += nums[i] == oddData? 0:1;
//            }
//        }
//        return res;


        int len = nums.length;
        int[] cnt1 = new int[100010];
        int[] cnt2 = new int[100010];
        int evenMax = 0, evenSub = 0;
        int oddMax = 0, oddSub = 0;
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            if (i % 2 == 0) {
                ++cnt1[x];
                if (cnt1[x] > cnt1[evenMax]) {
                    evenSub = evenMax;
                    evenMax = x;
                } else if (x != evenMax && cnt1[x] > cnt1[evenSub]) evenSub = x;
            } else {
                ++cnt2[x];
                if (cnt2[x] > cnt2[oddMax]) {
                    oddSub = oddMax;
                    oddMax = x;
                } else if (x != oddMax && cnt2[x] > cnt2[oddSub]) oddSub = x;
            }
        }
        if (evenMax != oddMax) return len - cnt1[evenMax] - cnt2[oddMax];
        return len - Math.max(cnt1[evenMax] + cnt2[oddSub], cnt1[evenSub] + cnt2[oddMax]);

    }
}
