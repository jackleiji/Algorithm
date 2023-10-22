package leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution84 {

    public int largestRectangleArea(int[] heights) {
        //单调栈+哨兵（首尾添加0项）
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int len = heights.length;
        if(len==0) return 0;
        if(len==1) return heights[0];
        int[] arr = new int[heights.length+2];
        for(int i=0;i<len;i++){
            arr[i+1] = heights[i];
        }
        //添加栈顶元素
        deque.addLast(0);
        for(int i=1;i<len;i++){
            //找到比当前位置大的前一柱子
            while (heights[deque.peekLast()]>heights[i]){
                //获取当前栈顶柱子高度
                int high = heights[deque.removeLast()];
                //判断是否有同高的柱子，有则出栈（只求最大值）
                while (!deque.isEmpty() && heights[deque.peekLast()] == high){
                    deque.pollLast();
                }
                int wide = i-deque.peekLast()-1;
                res = Math.max(res,wide*high);
            }
            deque.addLast(i);
        }
        return res;


        //单调栈
//        int res = 0;
//        Deque<Integer> deque = new ArrayDeque<>();
//        int len = heights.length;
//        for(int i=0;i<len;i++){
//            //找到比当前位置大的前一柱子
//            while (!deque.isEmpty() && heights[deque.peekLast()]>heights[i]){
//                //获取当前栈顶柱子高度
//                int high = heights[deque.pollLast()];
//                //判断是否有同高的柱子，有则出栈（只求最大值）
//                while (!deque.isEmpty() && heights[deque.peekLast()] == high){
//                    deque.pollLast();
//                }
//                int wide = 0;
//                if(deque.isEmpty()){
//                    wide = i;
//                }else {
//                    wide = i-deque.peekLast()-1;
//                }
//                res = Math.max(res,wide*high);
//            }
//            deque.addLast(i);
//        }
//        //弹栈，剩下的默认由小到大递增。
//        //若栈不为空，则宽度为当前位置-栈顶位置
//        //若为空，则柱高最小，宽度为len。
//        while (!deque.isEmpty()){
//            //获取当前栈顶柱子高度
//            int high = heights[deque.pollLast()];
//            //判断是否有同高的柱子，有则出栈（只求最大值）
//            while (!deque.isEmpty() && heights[deque.peekLast()] == high){
//                deque.pollLast();
//            }
//            int wide = 0;
//            if(deque.isEmpty()){
//                wide = len;
//            }else {
//                wide = len-deque.peekLast()-1;
//            }
//            res = Math.max(res,wide*high);
//        }
//        return res;
        //超时
//        int res =0;
//        int len = heights.length;
//        for(int i=0;i<len;i++){
//            int j = i-1,k=i;
//            int temp = heights[i];
//            while (j>=0 && heights[j]>=temp){
//                j--;
//            }
//            while (k<len&&heights[k]>=temp){
//                k++;
//                if(k>=len||heights[k]<temp){
//                    k--;
//                    break;
//                }
//            }
//            res = Math.max(res,heights[i]*(k-j));
//        }
//        return res;
    }

}
