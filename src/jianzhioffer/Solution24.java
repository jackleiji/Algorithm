package jianzhioffer;

public class Solution24 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode res = new ListNode();
        ListNode resIndex = res;
        ListNode in1 = head;
        ListNode in2 = head.next;
        while (in1!=null){
            ListNode temp = res.next;
            res.next = in1;
            res.next.next = temp;
            in1 = in2;
            in2 = in2.next;
            if(in2==null){
                ListNode temp2 = res.next;
                res.next = in1;
                res.next.next = temp2;
            }
        }
        return res.next;
    }
}
