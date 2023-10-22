package interview.wangyi0923;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        String[] arr= new String[n];
//        int[][] arrChar = new int[n][26];
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String temp = in.next();
            char[] letter = temp.toCharArray();
            Arrays.sort(letter);
            String str = Arrays.toString(letter);
            map.put(str,map.getOrDefault(str,0)+1);
        }
        Iterator it = map.values().iterator();
        long res = 0;
        while (it.hasNext()){
            Integer integer = (Integer) it.next();
            for(int i=1;i<integer;i++){
                res += i;
            }
        }
        System.out.println(res);
    }
}
