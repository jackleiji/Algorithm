import java.util.*;

public class Solution113 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        pathSum(root,-5);
        System.out.println(res.size());
        for(List i : res){
            System.out.println(i.toString());
        }
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        if(root==null || targetSum<root.val) return res;
        dfs(root,targetSum,new ArrayList<>(),0);
        return res;
    }
    public static void dfs(TreeNode node,int target,List<Integer> list,int sum){
        if(node==null) return;
        if(node.left==null && node.right==null){
            sum += node.val;
            if(sum==target) {
                list.add(node.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        sum += node.val;
        list.add(node.val);
        dfs(node.left,target,list,sum);
        dfs(node.right,target,list,sum);
        list.remove(list.size()-1);
    }
}
