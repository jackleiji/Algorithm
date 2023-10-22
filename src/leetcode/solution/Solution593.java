import java.util.*;

public class Solution593 {
    public static void main(String[] args) {
        int[] p1 = {0,0};
        int[] p2 = {1,1};
        int[] p3 = {1,0};
        int[] p4 = {0,1};
        System.out.println(validSquare(p1,p2,p3,p4));
    }
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //法一遍历，所有节点
//        Map<Double,Integer> map = new HashMap<Double, Integer>();
//        double p1p2 = Math.abs(Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2));
//        double p1p3 = Math.abs(Math.pow(p1[0]-p3[0],2)+Math.pow(p1[1]-p3[1],2));
//        double p1p4 = Math.abs(Math.pow(p1[0]-p4[0],2)+Math.pow(p1[1]-p4[1],2));
//        double p2p3 = Math.abs(Math.pow(p2[0]-p3[0],2)+Math.pow(p2[1]-p3[1],2));
//        double p2p4 = Math.abs(Math.pow(p2[0]-p4[0],2)+Math.pow(p2[1]-p4[1],2));
//        double p3p4 = Math.abs(Math.pow(p3[0]-p4[0],2)+Math.pow(p3[1]-p4[1],2));
//        map.put(p1p2,map.getOrDefault(p1p2,0)+2);
//        map.put(p1p3,map.getOrDefault(p1p3,0)+2);
//        map.put(p1p4,map.getOrDefault(p1p4,0)+2);
//        map.put(p2p3,map.getOrDefault(p2p3,0)+2);
//        map.put(p2p4,map.getOrDefault(p2p4,0)+2);
//        map.put(p3p4,map.getOrDefault(p3p4,0)+2);
//
//        if(map.size()!=2 || map.containsKey(0.0)) return false;
//        System.out.println(map.toString());
//        Collection<Integer> c = map.values();
//        if(c.contains(4)&&c.contains(8)){
//            return true;
//        }
//
//
//        return false;
        //法二：查看相邻点坐标
        int end_x = 0;
        int end_y = 0;

        List<int[]> p = new LinkedList<>();
        p.add(p2);
        p.add(p3);
        p.add(p4);
        for(int i=0;i<p.size();i++){
            System.out.println(i);
            if(p1[0] == p.get(i)[0]){
                end_y = p.get(i)[1];
                p.remove(i);
                i=0;
                continue;
            }else if(p1[1] == p.get(i)[1]){
                end_x = p.get(i)[0];
//                System.out.println(Arrays.toString(p.get(i)));
                p.remove(i);
                i=0;
                continue;
            }
        }

        if(p.size()==0) return false;
        else{
            if(p.get(0)[0]==end_x && p.get(0)[1]==end_y)
                return true;
            return false;
        }


    }
}
