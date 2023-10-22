package leetcode;

import java.util.Stack;

public class Solution143 {
    public void reorderList(ListNode head) {
        if(head==null || head.next == null || head.next.next==null){
            return;
        }
        ListNode left = head;
        ListNode right = head;
        Stack<ListNode> stack = new Stack<>();
        int len = 0;
        while (right!=null){
            len++;
            stack.add(right);
            right = right.next;
        }
        while (len>0 && left!=null){
            right = stack.pop();
            right.next = left.next;
            left.next = right;
            left = left.next.next;

            len-=2;
        }
        left.next = null;
    }
}
