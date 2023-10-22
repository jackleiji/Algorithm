package interview.didi0908;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String[] str = new String[len];
        for(int i=0;i<len;i++){
            str[i] = in.next();
        }
        Set<String> set = new HashSet<>();
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
               String temp1 = str[i]+str[j];
               String temp2 = str[j]+str[i];
               set.add(temp1.substring(1,temp1.length()-1));
               set.add(temp2.substring(1,temp2.length()-1));
            }
        }
//        System.out.println(set.toString());
        Set<String> res = new TreeSet<>();
        for(int i=0;i<len;i++){
            String temp1 = str[i];
            Iterator<String> it = set.iterator();
            while (it.hasNext()){
                String combineStr = it.next();
                if(combineStr.contains(temp1)){
                    res.add(temp1);
                    break;
                }
            }
        }
        System.out.println(res.size());
        Iterator<String> it = res.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
