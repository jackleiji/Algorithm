package interview.BaiduViewer;

import java.util.*;

public class Question1 {
    //    4 3
    //    -1 2 -1 3
    //out :0.50000000000
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        double[] ave = new double[k];//存放平均值
        for(int i=0;i<k;i++){
            List<Integer> digit = new ArrayList<>();
            digit.add(arr[i]);
            list.add(new ArrayList<>(digit));
            ave[i] = arr[i];
        }
        System.out.println(Arrays.toString(ave));
        for(int i=k;i<n;i++){
            int index_max = k-1;
            int index_min = 0;
            //获取最大位置值
            for(int j=0;j<k;j++){
                if(ave[j]>ave[index_max]){
                    index_max = j;
                }
                if(ave[j]<ave[index_min]){
                    index_min = j;
                }
            }

//            if(arr[i]>=0){
                list.get(index_max).add(arr[i]);
                ave[index_max] = average(list.get(index_max));
//            } else if(arr[i]<0){
//                list.get(index_min).add(arr[i]);
//                ave[index_min] = average(list.get(index_min));
//            }
        }
//        sum+=list.get(k-1)[0];
        double res = 0.0;
        for(int i=0;i<ave.length;i++){
            res+=ave[i];
        }
        System.out.println(res);
    }
    public static double average(List<Integer> list){
        double sum = 0;
        for(int i=0;i<list.size();i++){
            sum+=(double)list.get(i);
        }
        return sum/list.size();
    }
    public static int max_site(double[] ave){
        double site = ave[0];
        int index = 0;
        for(int i=1;i<ave.length;i++){
            if(site<ave[i]){
                index = i;
                site = ave[i];
            }
        }
        return index;
    }

}
