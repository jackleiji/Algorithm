package interview.anquan3600923;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        int seed = in.nextInt();
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<Q;i++){
            seed ^= seed<<15;
            seed ^= seed>>5;
            seed ^= seed<<1;
            seed %= (1<<15);

            int op = (seed^(seed<<7)^(seed>>5))%3+1;
            int m = (seed^(seed<<6)^(seed>>10))%Q+1;
            int x = (seed^(seed<<5)^(seed<<9)^(seed>>6))%10+1;

            if(op==1){//插入一次x
                map.put(x,map.getOrDefault(x,0)+1);
            }else if(op==2){//删除m个x
                if(!map.containsKey(x)) continue;
                int numb = map.get(x);
                if(numb<=m){
                    map.remove(x);
                }else {
                    map.put(x,numb-m);
                }
            }else {//求极差后，与res异或
//                if(map.size()<0) continue;
                Iterator iterator = map.keySet().iterator();
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                while (iterator.hasNext()){
                    Integer temp = (Integer) iterator.next();
                    max = Math.max(max,temp);
                    min = Math.min(min,temp);
                }
                if(max!=Integer.MIN_VALUE && min!=Integer.MAX_VALUE){
                    res ^= ((i+1)*(max-min));
                }
            }
        }

        System.out.println(res);
    }
}
