package interview.xinye0918;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        int[] waterStations = new int[]{1, 2, 3, 5, 7, 9};
        int[] volunteers = new int[]{2, 7};
        System.out.println(findRadius(waterStations,volunteers));
    }
    public static int findRadius (int[] waterStations, int[] volunteers) {
        // write code here
        int len = waterStations.length;
        int len_Vol = volunteers.length;
        int[] site = new int[len_Vol];
        int res = 0;
        for(int i=0;i<len;i++){
            int temp = waterStations[i];
            int resTemp = Integer.MAX_VALUE;
            for(int j=0;j<len_Vol;j++){
                resTemp = Math.min(resTemp,Math.abs(volunteers[j]-temp));
            }
            res = Math.max(res,resTemp);
        }
        return res;
    }
}
//[1, 2, 3, 5, 7, 9],[2, 7]
//[1,2,3,5,7][3]