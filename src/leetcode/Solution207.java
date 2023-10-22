package leetcode;

import java.util.ArrayList;

public class Solution207 {
    public static void main(String[] args) {
//        System.out.println(canFinish(4,new int[][]{{1,0},{2,0},{3,1},{3,2}}));
//        System.out.println(canFinish(20,new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
//        System.out.println(canFinish(4,new int[][]{{0,1},{3,1},{1,3},{3,2}}));
        System.out.println(canFinish(2,new int[][]{{0,1}}));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //1.邻接矩阵
//        boolean[][] arr = new boolean[numCourses][numCourses];
//        for(int i=0;i<prerequisites.length;i++){
//            arr[prerequisites[i][0]][prerequisites[i][1]] = true;
//        }
//        for(boolean[] a:arr){
//            System.out.println(Arrays.toString(a));
//        }
//        for(int i=0;i<numCourses;i++){
//            for(int j=i;j<numCourses;j++){
//                if(arr[i][j]&&arr[j][i]){
//                    return false;
//                }
//            }
//        }
//        return true;
        if(prerequisites.length==0) return true;
        //1.邻接列表
        ArrayList[] arr = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            arr[i] = new ArrayList();
        }
        for(int i=0;i<prerequisites.length;i++){
//            System.out.println(i+" "+prerequisites[0].length+" "+arr.length);
            if(prerequisites[i][1]==prerequisites[i][0]){
                return false;
            }
            arr[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(i+" "+arr[i].toString());
        }
        int[] flag = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            dfs(arr,flag,i);
            if(!fcir) break;
        }

        return fcir;
    }
    static boolean fcir = true;
    //深度优先遍历
    public static void dfs(ArrayList<Integer>[] arr ,int[] flag,int course){
        flag[course] = 1;
        for(int i:arr[course]){
            if(flag[i]==0){
                dfs(arr,flag,i);
                if(!fcir){
                    return;
                }
            }else if(flag[i]==1){
                fcir=false;
                return;
            }
        }
        flag[course] = 2;//有效
    }
}
