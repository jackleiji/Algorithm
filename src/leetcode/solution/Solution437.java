package leetcode.solution;

import java.util.LinkedList;

public class Solution437 {
    int ans;
    int tg;
    public int pathSum(TreeNode root, int targetSum) {
        //深度优先遍历，计算每个节点到叶子节点路径上的和，若==targetSum，则确定一条线路
        ans =0;
        tg = targetSum;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            int len = list.size();
            System.out.println(len);
            while (len-->0){
                TreeNode tn = list.poll();
                if(tn.left!=null) list.add(tn.left);
                if(tn.right!=null) list.add(tn.right);
                rootSum(tn,0);
            }
        }
        return ans;
    }
    public void rootSum(TreeNode root,int val){
        if(root==null) return;
        int value = val+root.val;
        if(value == tg) ans++;
        rootSum(root.left,value);
        rootSum(root.right,value);
    }
}
