package leetcode;

import java.util.*;

public class MedianFinder {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,1,2,3,123,432,2,1};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    //仅当循环取值时才能保证链表有序
    PriorityQueue<Integer> queMax;
    PriorityQueue<Integer> queMin;

    public MedianFinder() {
        queMax = new PriorityQueue<>((a,b)->(a-b));//小到大
        queMin = new PriorityQueue<>((a,b)->(b-a));//大到小
    }

    public void addNum(int num) {
        if(queMin.isEmpty() || num<=queMin.peek()){
            queMin.add(num);
            if(queMin.size()-1>queMax.size()){
                queMax.add(queMin.poll());
            }
        }else {
            queMax.add(num);
            if(queMax.size()>queMin.size()){
                queMin.add(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if(queMin.size()>queMax.size()){
            System.out.println(queMin.peek());
            return queMin.peek();
        }
        return (queMin.peek()+queMax.peek())/2.0;
    }
}

