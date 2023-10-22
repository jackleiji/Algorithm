package interview.weizongBank;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            queue.add(in.nextInt());
        }
        int[] res = new int[n];
        int index = 0;
        while (!queue.isEmpty()){
            int temp = queue.poll();
            if(queue.size()==0){
                res[index++] = temp;
                break;
            }
            res[index++] = temp;
            queue.add(queue.poll());
        }
//        System.out.println(Arrays.toString(res));
        for(int i=0;i<n;i++){
            System.out.println(res[i]);
        }
    }
}
