import java.util.*;

public class Solution797 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph,new ArrayList<>(),0);
        return res;
    }
    public void dfs(int[][] graph, List<Integer> list,int site){
        if(site<0||site>=graph.length-1){
            if(site==graph.length-1){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if(site==0) list.add(0);
        for(int i : graph[site]){
            list.add(i);
            dfs(graph,list,i);
            list.remove(list.size()-1);
        }
    }
}
