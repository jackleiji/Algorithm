package interview.SHEIN0926;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int totalLabel = 100;
        int res = 0;
        int[] timeArr = new int[n];
        for(int i=0;i<n;i++){
            timeArr[i] = in.nextInt();
            int quest = in.nextInt();
            if(i==0) totalLabel += (timeArr[i]/100)*10;
            else totalLabel += ((timeArr[i]-timeArr[i-1])/100)*10;
            if(totalLabel>=quest) totalLabel -= quest;
            else{
                res += (quest-totalLabel);
                totalLabel=0;
            }
        }
        System.out.println(res);
    }

}
