public class Solution230 {
    int res = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        midOrder(root,k);
        return res;
    }
    public void midOrder(TreeNode root,int k){
        if(root==null) return;
        if(root.left!=null){
            midOrder(root.left,k);
        }
        System.out.println(root.val);
        count++;
        if(count==k) res = root.val;
        if(k==0) System.out.println(root.val);
        if(root.right!=null){
            midOrder(root.right,k);
        }

    }
}
