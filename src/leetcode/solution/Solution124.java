package leetcode.solution;

public class Solution124 {
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sumDfs(root);
        return sum;
    }
    //深度优先遍历节点最大者
    public int sumDfs(TreeNode root){
        if(root==null) return 0;
        int rAddL = sumDfs(root.left)+root.val;
        int rAddR = sumDfs(root.right)+root.val;
        sum = Math.max(sum,rAddL+rAddR-root.val);
        return Math.max(Math.max(Math.max(rAddL,rAddR),root.val),0);
    }
}
