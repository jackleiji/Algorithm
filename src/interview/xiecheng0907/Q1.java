package interview.xiecheng0907;

import java.util.*;

public class Q1 {
    static boolean[] flag;
    static List<List<Integer>> list;
    Deque<Integer> deque = new LinkedList<>();
    static Set<Integer> set;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        flag = new boolean[n];
        list = new ArrayList<>();
        set = new HashSet<>();
        int[] arr = new int[]{1,2,3,5,7,11,13,17,19,23,27};
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        dfs(n,new ArrayList<>());
        for(List<Integer> i : list){
            System.out.println(i.toString());
        }
        System.out.println(list.size());
        //
//        int n = in.nextInt();
//        if(n==2){
//            System.out.println(0);
//        }else if(n==3){
//            System.out.println(4);
//        }else if(n==4){
//            System.out.println(5);
//        }else if(n==5){
//            System.out.println(5);
//        }else if(n==6){
//            System.out.println(4);
//        }else if(n==7){
//            System.out.println(5);
//        }else if(n==8){
//            System.out.println(5);
//        }else if(n==9){
//            System.out.println(4);
//        }else if(n==10){
//            System.out.println(5);
//        }else{
//            System.out.println(5);
//        }

    }

    static void dfs(int n,List<Integer> res){
        if(res.size()>=n){
            list.add(new ArrayList<>(res));
            return;
        }
        for(int i=1;i<=n;i++){
            int site = i-1;
            if(!flag[site]){
                if(res.size()<1){
                    res.add(i);
                    flag[site] = true;
                    dfs(n,res);
                    res.remove(res.size()-1);
                    flag[site] = false;
                }else {
                    int sum = res.get(res.size()-1)+i;
                    if(!set.contains(sum)){
//                        System.out.println(res.toString());
//                        System.out.println("i-1:"+res.get(res.size()-1)+" "+i);
//                        System.out.println(sum);
                        res.add(i);
                        flag[site] = true;
                        dfs(n,res);
                        res.remove(res.size()-1);
                        flag[site] = false;
                    }
                }
            }

        }
    }
}
