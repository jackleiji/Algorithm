package leetcode.solution;

import java.util.*;

public class Solution81 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        combin(candidates,target,new ArrayList<Integer>());
        return res;
    }
    public void combin(int[] candidates, int target,List<Integer> data){
        if(target<=0){
            data.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            if (target==0 && !res.contains(data)){
                res.add(new ArrayList<>(data));
                System.out.println(data.toString());
            }
            return;
        }

        for(int i=0;i<candidates.length;i++){
            target -= candidates[i];
            if(target>=0){
                data.add(candidates[i]);
                combin(candidates,target,data);
                data.remove(data.size()-1);
                target += candidates[i];
                continue;
            }
            break;
        }
    }
}
