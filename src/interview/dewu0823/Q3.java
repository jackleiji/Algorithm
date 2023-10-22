package interview.dewu0823;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,2};
//        HashSet set = new HashSet();
//        for(int i=0;i<arr.length;i++){
//            if(set.contains(arr[i])){
//                System.out.println(arr[i]);
//                break;
//            }
//            set.add(arr[i]);
//        }
        int res = 0;
        for(int i=0;i<arr.length;i++){
//            int temp = arr[i];
//            boolean flag = false;
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[j]==temp){
//                    System.out.println(temp);
//                    flag = true;
//                }
//                break;
//            }
//            if(flag) break;
            int temp = arr[i];
            res ^= temp;
            System.out.println(res);
        }
//        System.out.println(res);
    }
}
