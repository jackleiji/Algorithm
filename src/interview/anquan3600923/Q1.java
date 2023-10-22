package interview.anquan3600923;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0;i<n;i++){
            int temp = in.nextInt();
            arr[i] = temp;
            map.put(temp,map.getOrDefault(temp,0)+1);
            if(map.get(temp)>1){
                res++;
            }
        }
        System.out.println(res);
    }
}
