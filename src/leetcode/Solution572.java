package leetcode;

public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;

        return dfs(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean dfs(TreeNode r, TreeNode s){
        if(r==null&&s==null) return true;
        if(r==null || s==null) return false;

        if(r.val!=s.val) return false;
        return dfs(r.left,s.left) || dfs(r.right,s.right);
    }
}
