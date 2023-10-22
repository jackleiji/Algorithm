package leetcode;

import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> LeftToRight = new Stack<>();
        Stack<TreeNode> RightToLeft = new Stack<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        res.add(list);
        LeftToRight.add(root);
        boolean flag = false;
        while (LeftToRight.size()!=0 || RightToLeft.size()!=0){
            if(flag){//左至右
                List<Integer> listLR= new ArrayList<>();
                while (RightToLeft.size()!=0){
                    TreeNode treeNode = RightToLeft.pop();
                    if(treeNode.left!=null){
                        LeftToRight.add(treeNode.left);
                        listLR.add(treeNode.left.val);
                    }
                    if(treeNode.right!=null) {
                        LeftToRight.add(treeNode.right);
                        listLR.add(treeNode.right.val);
                    }
                }
                if(!listLR.isEmpty())
                    res.add(listLR);
                flag=false;
            }else {//右至左
                List<Integer> listRL= new ArrayList<>();
                while (LeftToRight.size()!=0){
                    TreeNode treeNode = LeftToRight.pop();
                    if(treeNode.right!=null){
                        RightToLeft.add(treeNode.right);
                        listRL.add(treeNode.right.val);
                    }
                    if(treeNode.left!=null) {
                        RightToLeft.add(treeNode.left);
                        listRL.add(treeNode.left.val);
                    }
                }
                if(!listRL.isEmpty())
                    res.add(listRL);
                flag=true;
            }
        }
        return res;
    }
}
