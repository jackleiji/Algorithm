public class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] parent = new int[len];
        //各自为政
        for(int i=0;i<len;i++){
            parent[i] = i;
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(isConnected[i][j] == 1){
                    union(parent,i,j);
                }
            }
        }

        int pr = 0;
        for(int i=0;i<len;i++){
            if(parent[i] == i){
                pr++;
            }
        }

        return pr;
    }
//    合并（Union）：把两个不相交的集合合并为一个集合。
    public void union(int[] parent,int x,int y) {
        if(x == y) return;
        //所有节点指向y的父节点
        parent[find(parent,x)] = find(parent,y);
    }
//    查询（Find）：查询两个元素是否指向同一个集合中。
    public int find(int[] parent, int index) {
        if(parent[index] != index){
            return find(parent,parent[index]);
        }
        return index;
    }
}
