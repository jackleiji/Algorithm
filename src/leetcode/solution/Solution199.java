import java.util.*;

public class Solution199 {
    List<Integer> dfs_res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if(root == null) return res;
        queue1.add(root);
        boolean flag = false;

        while (!queue1.isEmpty() || !queue2.isEmpty()){

            if(flag){
                TreeNode oddNode = queue2.poll();
                if(oddNode!=null)
                    res.add(oddNode.val);
                while (oddNode!=null){
                    if(oddNode.right!=null){
                        queue1.add(oddNode.right);
                    }
                    if (oddNode.left!=null){
                        queue1.add(oddNode.left);
                    }
                    oddNode = queue2.poll();
                }
                flag =false;
            }else {
                TreeNode evenNode = queue1.poll();
                if(evenNode!=null)
                    res.add(evenNode.val);
                while (evenNode!=null){
                    if(evenNode.right!=null){
                        queue2.add(evenNode.right);
                    }
                    if (evenNode.left!=null){
                        queue2.add(evenNode.left);
                    }
                    evenNode = queue1.poll();
                }
                flag =true;
            }
        }
        return res;
    }
    //法二：递归
    public void dfs(TreeNode node, int row){
        if(node==null) return;
        if(row==dfs_res.size()){
            dfs_res.add(node.val);
        }
        row++;
        dfs(node.right,row);
        dfs(node.left,row);
    }
}
