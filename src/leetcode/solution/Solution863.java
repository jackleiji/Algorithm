package leetcode.solution;

import java.util.*;

public class Solution863 {
    List<Integer> res = new ArrayList<>();
    Map<Integer,TreeNode> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findparent(root);
        Set<Map.Entry<Integer,TreeNode>> set = map.entrySet();
        Iterator<Map.Entry<Integer,TreeNode>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,TreeNode> i_map = iterator.next();
            System.out.println(i_map.getKey()+" "+i_map.getValue());
        }
        findAns(target,null,0,k);
        return res;
    }
    public void findparent(TreeNode node){
        if(node.left!=null){
            map.put(node.left.val,node);
            findparent(node.left);
        }
        if(node.right!=null){
            map.put(node.right.val,node);
            findparent(node.right);
        }
    }
    public void findAns(TreeNode target,TreeNode source,int depth,int k){
        if(target==null) return;
        if(depth==k){
            res.add(target.val);
            return;
        }
        if(target.left!=source){
            findAns(target.left,target,depth+1,k);
        }
        if(target.right!=source){
            findAns(target.right,target,depth+1,k);
        }
        if(map.get(target.val)!=source){
            findAns(map.get(target.val),target,depth+1,k);
        }
    }
}
