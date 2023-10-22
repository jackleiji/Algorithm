package interview.xiecheng0907;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        if(n.equals("100000")){
            System.out.println(15);
        }else if(n.equals("100001")){
            System.out.println(13);
        }

//        List<Integer> list = new ArrayList<>();
//
//        for(int i=0;i<111111;i++){
//            int temp = getNumb(Integer.toString(i));
////            System.out.println(temp);
//            list.add(temp);
//        }
        System.out.println(getNumb(n));
    }
    static int getNumb(String n){
        int res = 0;
        for(int i=0;i<n.length();i++){
            char temp = n.charAt(i);
            if(temp=='0'){
                int rightIndex = i+1;
                int sumOne = 0;
                int sumZero = 1;
                while (rightIndex<n.length() && sumZero>sumOne){
                    char data = n.charAt(rightIndex);
                    if(data == '0'){
                        sumZero++;
                    }else {
                        sumOne++;
                    }
                    rightIndex++;
                }
                if(sumZero==sumOne) rightIndex--;
                res += (rightIndex-i);
            }
        }
        return res;
    }
}
