package jianzhioffer;

import java.util.*;

public class Solution27 {
    public boolean isPalindrome(ListNode head) {
        ListNode index = head;
        Stack<ListNode> stack = new Stack<>();
        while (index!=null){
            stack.add(index);
            index = index.next;
        }
        index = head;
        while (!stack.isEmpty()){
            ListNode temp = stack.pop();
            if(temp.val!=index.val)
                return false;
            index = index.next;
        }
        return true;
    }
}
