package interview.zhihu0916;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        getNewLinkedList(new int[]{2,4,1,3,5});
    }
    public static ArrayList<Integer> getNewLinkedList (int[] linkeds) {
        // write code here
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int len = linkeds.length;
        for(int i=0;i<len;i++){
            if(i%2==1){
                odd.add(linkeds[i]);
            }else {
                even.add(linkeds[i]);
            }
            temp.add(linkeds[i]);
        }
        odd.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        even.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        ArrayList<Integer> res = new ArrayList<>();
        res.addAll(odd);
        res.addAll(even);
//        res.addAll(even);
        System.out.println(odd.toString());
        System.out.println(res.toString());
        return odd;
    }
}
