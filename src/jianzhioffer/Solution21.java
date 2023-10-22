package jianzhioffer;

import java.util.*;
import java.util.Queue;

public class Solution21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        ListNode index = head;
        int len = 0;
        List<ListNode> list = new LinkedList<>();
        while (index!=null){
            list.add(index);
            index = index.next;
            len++;
        }
        if(len==n) head=head.next;
        else list.get(len-n-1).next = list.get(len-n).next;
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "val=" + val + (next==null? "" :next.toString());
    }
}