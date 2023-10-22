import java.util.*;

public class Solution1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        //入度为0的点即为要入队的节点
        List<Integer> res = new ArrayList<>();
        boolean[] flag = new boolean[n];
        for(List<Integer> list : edges){
            int right = list.get(1);
            flag[right] = true;
        }
        for(int i=0;i<n;i++){
            if(!flag[i]) res.add(i);
        }
        return res;
    }
}
