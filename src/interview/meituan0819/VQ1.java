package interview.meituan0819;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class VQ1 {
    public static void main(String[] args) {

    }
    public boolean isCompleteTree (TreeNode root) {
        if (root == null) return true;
        // write code here
        Queue<TreeNode> list = new LinkedBlockingDeque<>();
        list.add(root);
        int index = 0;
        while (!list.isEmpty()) {
            int len = list.size();
            int i = 0;
            while (i<len){
                TreeNode tn = list.peek();
                System.out.println(tn.val);
                i++;
                if (tn.left == null && tn.right != null) {
                    return false;
                }
                if (tn.left != null) {
                    list.add(tn.left);
                }
                if (tn.right != null) {
                    list.add(tn.right);
                }
                list.poll();
            }
        }
        return true;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
        }
    }