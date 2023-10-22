public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;
        ListNode res = new ListNode(0);
        ListNode res_index = res;
        while (second!=null){
            res_index.next = second;
            second.next = first;
            res_index = res_index.next.next;
            res_index.next = null;

            if(third == null) break;
            else if(third.next == null) {
                res_index.next = third;
                break;
            }
            first = third;
            second = first.next;
            third = second.next;
        }

        return res.next;
    }
}
