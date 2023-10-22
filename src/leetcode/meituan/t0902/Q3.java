package leetcode.meituan.t0902;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int top = in.nextInt();
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n-1;i++){
            int temp = in.nextInt();
            queue.add(temp);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        int temp = queue.poll();
        int res = 0;
        while (top<temp){
            top*=2;
            res++;
        }
        if(map.get(temp)>1){
            System.out.println(res);
        }else {
            if(temp%2==1){
                System.out.println(res-1);
            }else {
                System.out.println(res);
            }
        }


    }
}
