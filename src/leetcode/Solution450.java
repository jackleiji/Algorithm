package leetcode;

public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        //二叉搜索树，左小右大
        //小往左侧找，大往右侧找
        //若为根节点直接删除；
        //若为单边子树，将单边数据写入删除节点；
        //若存在子树，从左子树取最大值作为填充
        if(root == null) return null;
        if(root.val < key){
            root.right = deleteNode(root.right,key);
            return root;
        }else if(root.val > key){
            root.left = deleteNode(root.left,key);
            return root;
        }else {
            if(root.right == null && root.left==null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            TreeNode succession = root.left;
            while (succession.right!=null){
                succession = succession.right;
            }
            root.left = deleteNode(root.left,succession.val);
            succession.left = root.left;
            succession.right = root.right;
            return succession;
        }
    }
}
