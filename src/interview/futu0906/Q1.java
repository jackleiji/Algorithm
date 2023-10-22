package interview.futu0906;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int temp = in.nextInt();
            int res = 0;
            if(map.containsKey(temp)){
                System.out.println(map.get(temp));
                continue;
            }
            for(int j=1;j<=temp;j++){
                res += getBinary(j);
            }
            System.out.println(res);
            map.put(temp,res);
        }
    }
    static int getBinary(int numb){
        int res = 0;
        while (numb!=0){
            int temp = numb%2;
            if(temp==0){
                break;
            }
            numb = numb>>1;
            res = (res<<1)+1;
        }
        return res;
    }
}
