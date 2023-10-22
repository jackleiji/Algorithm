package jianzhioffer;

public class Solution22 {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) return null;
        ListNode one = head.next;
        ListNode two = head.next.next;
        ListNode thr = head;
        while (!one.equals(two)){
            if(two.next==null||two.next.next==null) return null;
            one = one.next;
            two = two.next.next;
        }
        while (!thr.equals(two)){
            thr = thr.next;
            two = two.next;
        }
        return thr;
    }
}
