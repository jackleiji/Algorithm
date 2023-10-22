package leetcode.solution;

import java.util.*;

public class Solution99 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        midOrder(root,list);
//        System.out.println(list.toString());
        int len = list.size();
        int left = 0;
        int right = len-1;
        while (left<right){
            int left_index= left;
            int right_index = right;

            if(list.get(left_index).val<list.get(left_index+1).val){
                left++;
            }
            if(list.get(right_index).val>list.get(right_index-1).val){
                right--;
            }
            if(left==left_index&& right==right_index) break;
        }
        System.out.println(left+" "+right);
        int temp = list.get(left).val;
        list.get(left).val = list.get(right).val;
        list.get(right).val = temp;
    }

    public void midOrder(TreeNode root, List<TreeNode> list){
        if(root.left!=null){
            midOrder(root.left,list);
        }
        list.add(root);
        if(root.right!=null){
            midOrder(root.right,list);
        }
    }
}
