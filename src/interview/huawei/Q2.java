package interview.huawei;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        //滑动窗口,长度最大为min(len,12)，最小长度为3；
        Scanner scan = new Scanner(System.in);
//        String encoder = scan.next();
//        String key = scan.next();
//        String sign = scan.next();
        String encoder = "139804444677899222"; //M
        String key = "2"; //N
        String sign = "*"; //k
        long target = 0;
        long res = Integer.MIN_VALUE;
        int len = encoder.length();
        for(int i=Math.min(12,encoder.length());i>2;i--){
            for(int j=0,k=j+i;k<encoder.length();j++,k++){
                Long numb = Long.parseLong(encoder.substring(j,k+1));
                if(compareNumb(numb,Long.parseLong(key),sign)){
                    res = Math.max(res,numb);
                }
            }
        }
        System.out.println(res == Integer.MIN_VALUE?-1:res);
    }
    public static boolean compareNumb(Long encoder,Long N,String sign){
        if(sign.equals("-")){
            return whetherEqu(encoder-N);
        }else if(sign.equals("+")){
            return whetherEqu(encoder+N);
        }else if(sign.equals("*")){
            return whetherEqu(encoder*N);
        }
        return false;
    }
    public static boolean whetherEqu(Long numb){
        Long i = numb%10;
        numb /= 10;
        while (numb>0){
            Long temp = numb%10;
            if(!temp.equals(i)){
                return false;
            }
            numb /= 10;
        }
        return true;
    }
}
