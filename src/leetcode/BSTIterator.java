package leetcode;

import java.util.*;

public class BSTIterator {
    public int index = 0;
    public List<Integer> arr = new ArrayList<Integer>();

    public BSTIterator(TreeNode root) {
        midOrder(root);
    }

    public int next() {
        return arr.get(index++);
    }

    public boolean hasNext() {
        return index < arr.size();
    }

    public void midOrder(TreeNode root){
        if(root == null){
            return;
        }
        midOrder(root.left);
        arr.add(root.val);
        midOrder(root.right);
    }
}
