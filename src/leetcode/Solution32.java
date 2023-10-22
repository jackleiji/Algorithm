package leetcode;

import java.util.*;

public class Solution32 {
    public int longestValidParentheses(String s) {
        //栈：
        //"("位置入栈，")"弹栈，判断栈是否为空，空则入栈。非空，当前")"对应子串长度为：")"位置-栈顶位置。
        //每次弹栈都更新最长子串长度。
        Deque<Integer> deque = new ArrayDeque<>();
        int len = s.length();
        if(len<2) return 0;
        int res = 0;
        deque.addLast(-1);
        for(int i=0;i<len;i++){
            char sign = s.charAt(i);
            if(sign=='('){
                deque.addLast(i);
            }else {
                deque.pollLast();
                if(deque.isEmpty()){
                    deque.addLast(i);
                }else {
                    res = Math.max(res,i-deque.peekLast());
                }
            }
        }
        return res;
    }
}
