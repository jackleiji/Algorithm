package interview.xiaohongshu0819;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        //构造map存储次数。构造优先级队列。从小到大计数。>=numb择表示记住了。
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();//记录已经背过的单词
        int res = 0;
        int count =1;
        for(int i=0;i<n;i++){
            String temp = scan.next();
            if(!set.contains(temp)){
                int numb = map.getOrDefault(temp,0)+1;
                if(numb>=count){
                    count++;
                    set.add(temp);
                    res++;
                }
                map.put(temp,numb);
            }

        }
        System.out.println(res);

//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        Collection values = map.values();
//        for(Object i : values){
////            System.out.println(Integer.parseInt(i.toString()));
//            pq.add(Integer.parseInt(i.toString()));
//        }
//        int res = 0;
//        int count =1;
//        while (!pq.isEmpty()){
//            System.out.println(pq.peek());
//            if(pq.peek()!=null && pq.poll()>=count){
//                count++;
//                res++;
//            }
//        }
//        System.out.println(res);
    }
}
