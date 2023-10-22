package interview.pinan1009;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        String numb = Long.toString(in.nextLong());
        StringBuilder sb1 = new StringBuilder(numb);
        for(int i=0;i<=20;i++){
//            System.out.println(numb+" "+rNumb);
//            System.out.println(sb1 + " "+sb1.reverse());
            if(sb1.toString().equals(sb1.reverse().toString())) {
                System.out.println("STRP=" + i);
                return;
            }
            sb1 = new StringBuilder(addForM(sb1.toString(),sb1.reverse().toString(),m));
        }
        System.out.println("Impossible");
    }
    static String addForM(String numb,String rNumb,int m){
        String s1 = numb;
        String s2 = rNumb;
        System.out.println(s1+" "+s2+" "+m);
        int temp = 0;
        StringBuilder res = new StringBuilder();
        for(int i =s1.length()-1,j=rNumb.length()-1;i>=0||j>=0;i--,j--){
            int sum = temp;
            sum += i>0?s1.charAt(i)-'0':0;
            sum += j>0?s2.charAt(j)-'0':0;
            res.append(sum%m);
            temp=sum/m;
        }
        res.append(temp!=0?temp:"");
        System.out.println(m);
        return res.reverse().toString();
    }
    static long reverseNumb(long numb){
        long res = 0;
        while (numb>0){
            res = res * 10+numb%10;
            numb /=10;
        }
        return res;
    }
}
