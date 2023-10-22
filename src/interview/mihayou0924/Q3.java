package interview.mihayou0924;

import java.util.*;

public class Q3 {
    static List<List<Integer>> listSub;
    static boolean[] flag;
    static long resSum;
    static long mod = (long) (10E9+7);
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n = in.nextInt();
//        long[] arr = new long[n];
////        List<Integer> b = new LinkedList<>();
//        for(int i=0;i<n;i++){
//            arr[i] = in.nextInt();
//        }
//        for(int i=1;i<n+1;i++){
//            long mul = arr[i-1];
//            long sum = 0;
//            for(int j=i+1;j<n+1;j++){
//                mul *= arr[j-1];
//                System.out.println(j+" "+i+" "+mul);
//                sum += (j-i)*mul;
//            }
//            resSum = (resSum+sum)%mod;
//        }
//        System.out.println(resSum);
//    }

//10
//100 225 323 1654 256 1598 120 151 1 1561
//3
//1 25 2
//3
//4 3 6
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n = in.nextInt();
//        long[] arr = new long[n];
//        List<Integer> b = new LinkedList<>();
//        for(int i=0;i<n;i++){
//            arr[i] = in.nextInt();
//            for(int j=0;j<arr[i];j++){
//                b.add(i);
//            }
//        }
//        listSub = new LinkedList<>();
//        flag = new boolean[b.size()];
//        getSubList(b,new LinkedList<>(),0);
//        System.out.println(resSum%mod);
//    }
    static void getSubList(List<Integer> b,List<Integer> bSub,int index){
        if(index>=b.size()) return;
        if(bSub.size()>1&&!listSub.contains(bSub)&&bSub.get(bSub.size()-1)-bSub.get(0)!=0){
            resSum += bSub.get(bSub.size()-1)-bSub.get(0)%mod;
            System.out.println(bSub.toString());
            System.out.println(bSub.get(bSub.size()-1)-bSub.get(0));
            listSub.add(new LinkedList<>(bSub));
        }
        for(int i=index;i<b.size();i++){
            if(!flag[i]){
                bSub.add(b.get(i));
                flag[i] = true;
                getSubList(b,bSub,i);
                bSub.remove(bSub.size()-1);
                flag[i] = false;
            }
        }
    }
}
