import java.util.*;

public class Solution90 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subArr(nums,new ArrayList<>(),0);

        return res;
    }
    public void subArr(int[] nums,List<Integer> list,int index){
        if(index>nums.length) return;
        if(!res.contains(list)){
            res.add(new ArrayList<>(list));
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            subArr(nums,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
