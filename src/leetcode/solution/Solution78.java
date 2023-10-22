import java.util.*;

public class Solution78 {
    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
        for(List<Integer> list : res){
            System.out.println(list);
        }
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        subArr(nums,new ArrayList<>(),0);
        return res;
    }
    public static void subArr(int[] nums,List<Integer> list,int index){
        res.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            subArr(nums,list,i+1);
            list.remove(list.size()-1);
        }
    }

}
