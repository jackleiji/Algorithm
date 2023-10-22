package leetcode.solution;

import java.util.*;

public class Solution149 {
    public static void main(String[] args) {
//        System.out.println(maxPoints(new int[][]{{7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},{-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},{-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},{10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},{-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},{-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},{-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},{9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},{15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},{4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},{-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},{5,-17},{6,-6},{-11,-8}}));
//        System.out.println(maxPoints(new int[][]{{4,5},{4,-1},{4,0}}));
        System.out.println(maxPoints(new int[][]{{3,3},{1,4},{1,1},{2,1},{2,2}}));
    }
    public static int maxPoints(int[][] points) {
        if(points.length==1) return 1;
        Map<String,Set<String>> map = new TreeMap<>();
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                String str = " ";
                if(points[i][1] == points[j][1]){
                    str = "y equal "+points[j][1];
                }else if(points[i][0] == points[j][0]){
                    str = "x equal "+points[j][0];
                }else{
                    Double k = (double) (points[i][1]-points[j][1])/(points[i][0]-points[j][0]);
                    Double b = points[i][1]-k*points[i][0];
                    str = k+" "+b;
//                    System.out.println(str);
                    if(str.equals("-Infinity -Infinity") || str.equals("Infinity Infinity")||str.equals("-Infinity Infinity")||str.equals("Infinity -Infinity")) continue;
                }
                //获取旧的set表
                System.out.println(str+"-------------");
                Set<String> set = map.getOrDefault(str,new HashSet<>());
                set.add(points[i][0]+" "+points[i][1]);
                set.add(points[j][0]+" "+points[j][1]);
                map.put(str,set);
                for(String a:set){
                    System.out.println(a);
                }
            }
        }

        Iterator<Set<String>> iterator = map.values().iterator();
        int res= 0;
        while (iterator.hasNext()){
            int temp = iterator.next().size();
            if(temp>res){
                res=temp;
            }
        }
        iterator = map.values().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        return res;
    }
}
