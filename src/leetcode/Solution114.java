package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution114 {
    Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        preOrder(root);
        root.left=null;
        TreeNode index = root;
        queue.poll();
        int size = queue.size();
        for(int i=0;i<size;i++){
            index.right=new TreeNode(queue.poll().val);
            index=index.right;
        }
    }
    public void preOrder(TreeNode node){
        queue.add(node);
        if(node.left!=null) preOrder(node.left);
        if(node.right!=null) preOrder(node.right);
    }
}
