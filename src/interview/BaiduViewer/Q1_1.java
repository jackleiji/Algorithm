package interview.BaiduViewer;

import java.util.*;

public class Q1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        List<Integer[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        double[] ave = new double[k];//存放平均值
        for(int i=0;i<k;i++){
            list.add(new Integer[]{arr[i]});
            ave[i] = arr[i];
        }
        int index = k;
        int max_index = k-1;
        int sum = 0;
        for(int i=k;i<n;i++){
            sum+=arr[i];
        }
        sum+=list.get(k-1)[0];
        double res = (double)sum/(n-k+1);
        for(int i=0;i<list.size()-1;i++){
            res+=list.get(i)[0];
        }
        System.out.println(res);
    }
}
