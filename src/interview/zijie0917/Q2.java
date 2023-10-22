package interview.zijie0917;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        String target = in.next();
        for(int i=0;i<q;i++){
            int res=0;
            String str = in.next();
            if(str.length()>n){
                continue;
            }
            for(int indexleft=0;indexleft<n;indexleft++){
                char targetChar;
                int indexright = indexleft;
                for(int j = 0;j<str.length();j++){
                    char strChar = str.charAt(j);
                    targetChar = target.charAt(indexright);
                    if(targetChar == strChar){
                        indexright++;
                    }else {
                        break;
                    }
                    if(indexright-indexleft==str.length()){
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
