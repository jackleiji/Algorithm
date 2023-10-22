public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==1) return new TreeNode(nums[0]);
        return creatTree(nums,0,nums.length-1);
    }
    public TreeNode creatTree(int[] nums, int start, int end){
        if(start>end) return null;
        int mid = (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = creatTree(nums,start,mid-1);
        root.right = creatTree(nums,mid+1,end);

        return root;
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