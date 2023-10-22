package leetcode.meituan.t0422;
import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int day = scanner.nextInt();
        int[][] crops = new int[3][n];
        //0行时间，1行成本，2行售价
        for (int i = 0; i < 3; i++) {
            for(int j=0;j<n;j++){
                crops[i][j] = scanner.nextInt();
            }
        }
//        for(int[] a:crops){
//            System.out.println(Arrays.toString(a));
//        }
        //计算每个植物每天的利润
        float[] a = new float[n];
        for(int i=0;i<n;i++){
            a[i] = (float) (crops[2][i]-crops[1][i])/crops[0][i];
        }
//        System.out.println(Arrays.toString(a));
        float money = 0;
        while (day>0){
            int crop = -1;
            float maxlirun = 0;
            for(int i=0;i<n;i++){//找最大利润作物
                if(crops[0][i]<day&&a[i]>maxlirun){
                    crop=i;
                    maxlirun=a[i];
                }
            }
            if(crop!=-1){
                day-=crops[0][crop];
                money += (crops[2][crop]-crops[1][crop]);
            }else {
                break;
            }
        }
        System.out.println(money);

//        Arrays.sort(crops, Comparator.comparingInt(a -> a[0])); // 按照成熟时间从小到大排序
//        int currentMoney = money;
//        int currentTime = 0;
//        for (int i = 0; i < n; i++) {
//            int timeNeeded = crops[i][0] - currentTime; // 时间差
//            int maxProfit = 0;
//            int maxIndex = -1;
//            for (int j = i; j < n && crops[j][0] - currentTime <= timeNeeded; j++) {
//                int profit = crops[j][2] - crops[j][1];
//                if (profit > maxProfit) {
//                    maxProfit = profit;
//                    maxIndex = j;
//                }
//            }
//            if (maxIndex == -1) {
//                break; // 找不到能够种植的作物了
//            }
//            int cost = crops[maxIndex][1];
//            if (cost <= currentMoney) {
//                currentMoney -= cost;
//                currentMoney += crops[maxIndex][2];
//                currentTime += timeNeeded;
//            }
//        }
//        System.out.println(currentMoney);
    }
}

