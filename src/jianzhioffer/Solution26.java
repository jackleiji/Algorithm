package jianzhioffer;

import java.util.Stack;

public class Solution26 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        System.out.println(head.toString());
    }
    public static void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode index = head;
        while (index!=null){
            stack.add(index);
            index = index.next;
        }
        index = head;
        int flag = stack.size()/2,len = stack.size()/2;
        ListNode indexStack = stack.pop();
        while (len>0){
            len--;
            ListNode temp = index.next;
            if(temp.equals(indexStack)){
//                temp.next = null;
                index = temp;
                break;
            }
            index.next = indexStack;
            indexStack.next=temp;
            indexStack = stack.pop();
            index = temp;

        }
        index.next = null;
    }
}
