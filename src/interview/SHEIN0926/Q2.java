package interview.SHEIN0926;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.next();
        int n = in.nextInt();
        int len = (str.length()/n)+1;
        StringBuilder res = new StringBuilder();
        for(int i =0;i<n;i++){
            for(int j=0;j<len;j++){
                if(i%((2*n-2)-1)==0){
                    int index = j*(2*n-2);
                    if(index<str.length())
                     res.append(str.charAt(index));
                }else
                    if(i%((2*n-2)-1)==n-1){
                    int index = (j+1)*(2*n-n-1);
                    if(index<str.length())
                        res.append(str.charAt(index));
                }
                    else {
                    int index1 =j*(2*n-2)+i;
                    int index2 =(j+1)*(2*n-2)-i;
                    if(index1<str.length())
                        res.append(str.charAt(index1));
                    if(index2<str.length()){
                        res.append(str.charAt(index2));
                    }
                }

            }
        }

        System.out.println(res.toString());
    }
}
