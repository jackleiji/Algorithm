package leetcode.solution;
import java.util.*;

public class Solution75 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        int numb = scan.nextInt();
//        System.out.println(numb);
        int[] nums = {1,1,1,2,2,2,0,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void sortColors(int[] nums) {
        //法一:插入参数
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//        }
//        int site = 0;
//        for(int i=0;i<3;i++){
//            int value = map.getOrDefault(i,0);
//            for(int j=0;j<value;j++){
//                nums[site] = i;
//                site++;
//            }
//        }
        //法二：选择排序
//        int index = 0;
//        while (index<nums.length){
//            int site = index;
//            for(int i=index+1;i<nums.length;i++){
//                if(nums[site]>nums[i]){
//                    site = i;
//                }
//            }
//            swap(nums,site,index);
//            index++;
//        }
        //法三：快速排序
        quickSort(nums,0,nums.length-1);

    }
    static void quickSort(int[] nums, int left, int right){
        int l = left;
        int r = right;
        int mid = nums[(left+right)/2];
        while (l<r){
            while (nums[l]<mid){
                l++;
            }
            while (nums[r]>mid){
                r--;
            }
            if(l>=r) break;

            swap(nums,l,r);

            if(nums[l] == mid)
                r--;
            if(nums[r]==mid)
                l++;
        }

        if(l==r){
            l++;
            r--;
        }
        if(l<right)
            quickSort(nums,l,right);
        if(r>left)
            quickSort(nums,left,r);
    }
    static void swap(int[] nums, int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
