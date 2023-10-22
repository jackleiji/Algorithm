package interview.zhongguoyidong1015;
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        if(str.length()==1) {
            System.out.println(1);
            return;
        }
        long resMax = 0;
        int left = 0, right = 0;
        while (left<str.length()){
            char lTemp = str.charAt(left);
            char rTemp = str.charAt(right);
            boolean flag = false;
            if(lTemp==rTemp){
                resMax = Math.max(resMax,right-left+1);
                if(right==str.length()-1){
                    int rIndex = 0;
                    while (rIndex<left){
                        char rIndexTemp = str.charAt(rIndex);
                        if(rIndexTemp == lTemp){
                            resMax = Math.max(resMax,rIndex-left+str.length()+1);
                            rIndex++;
                        }else {
                            break;
                        }
                    }
                    flag = true;
                }
            }else {
                left = right;
            }
            if(flag) break;
            if(right<str.length()-1){
                right++;
            }
        }
        System.out.println(resMax);
    }
}
