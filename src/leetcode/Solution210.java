package leetcode;

import java.util.*;

class Solution210 {
    List<Integer> list = new ArrayList<>();
    boolean f_cir = true;
    int[] flag ;
    int[] res;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] arr = new ArrayList[numCourses];
        index =numCourses-1;
        for(int i=0;i<numCourses;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            arr[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        flag = new int[numCourses];
        res = new int[numCourses];
        for(int i=0;i<numCourses && f_cir;i++){
            if(flag[i]==0)
                dfs(arr,i);
        }
        if(!f_cir) return new int[0];

        return res;
    }
    public void dfs(ArrayList<Integer>[] arr,int course){
        flag[course] = 1;
        for(int i:arr[course]){
            if(flag[i]==0){
                dfs(arr,i);
                if(!f_cir){
                    return;
                }
            }else if(flag[i]==1){
                f_cir=false;
                return;
            }
        }
        flag[course] = 2;
        res[index--] = course;
    }
}