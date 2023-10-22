package interview.wangyi0923;
import java.util.*;

//第三题问给定数组的所有子序列平均数之和。
//方式是算每个数字对结果的贡献，比如[1,2,3,4]。1贡献为1的有一个,[1]。1贡献为1/2的有三个，[1,2],[1,3],[1,4]。1贡献为1/3的有3个，
//贡献为1/4的有1个。就是C^{i}_{n-1} / i+1，其中 i 从1遍历到n-1。然后 p / q 要转变成 p * q ^ {MOD - 2} 。

public class Q3 {
    static List<List<Integer>> list;
    static boolean[] flag;
    static Map<Integer,Long> map;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        flag = new boolean[n];
        for(int i =0;i<n;i++){
            arr[i] = in.nextInt();
        }

        list = new ArrayList<>();
        map = new HashMap<>();
        getSubList(arr,new LinkedList<>(),0);
        Iterator it = map.entrySet().iterator();
        long numb = (long)Math.pow(10,9)+7;
        long res = 0;
        while (it.hasNext()){
            Map.Entry<Integer,Long> entry = (Map.Entry<Integer, Long>) it.next();
//            System.out.println(entry.getKey()+" "+entry.getValue());
            if(entry.getKey()!=0){
                res += ((long)entry.getValue()/entry.getKey())%numb;
            }
        }

        System.out.println((int)res);



    }

    static void getSubList(int[] arr,List<Integer> subList,int index){
        if(index>arr.length) return;
        list.add(new LinkedList<>(subList));
//        System.out.println(subList.toString());
        long sum = subList.stream().mapToInt(Integer::intValue).sum();
        map.put(subList.size(),map.getOrDefault(subList.size(),(long)0)+sum);
        for(int i=index;i<arr.length;i++){
            if(!flag[i]){
                flag[i] = true;
                subList.add(arr[i]);
                getSubList(arr,subList,i);
                flag[i] = false;
                subList.remove(subList.size()-1);
            }
        }
    }
    static double ramainder(double dividend,double dividor){
        return dividend - dividend/dividor*dividor;
    }

}
