package leetcode;

import java.util.*;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        //利用栈的思想，当检测到大于栈底元素的数字时，进行弹栈操作
        //之后将新值入栈；
        //到数组尾部依旧没有检测到大于栈内元素的数值时，弹栈
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while (!stack.isEmpty()&&temperatures[stack.peek()] <temperatures[i]){
                int temp = stack.pop();
                res[temp] = i-temp;
            }
            stack.add(i);
        }

        return res;
    }
}
