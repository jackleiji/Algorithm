import java.util.*;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        HashMap<Integer,Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            valueIndexMap.put(inorder[i],i);
        }
        return f(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, valueIndexMap);
    }

    public TreeNode f(int[] pre,int L1,int R1,int[] in,int L2,int R2,HashMap<Integer,Integer> valueIndexMap){
        if (L1 > R1)
            return null;
        TreeNode head = new TreeNode(pre[L1]);
        int find = valueIndexMap.get(pre[L1]);
        head.left = f(pre, L1+1, L1+(find-L2), in, L2, find-1, valueIndexMap);
        head.right = f(pre, L1+(find-L2)+1, R1, in, find+1, R2, valueIndexMap);
        return head;
    }
}
