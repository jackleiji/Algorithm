package leetcode;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast_index = head;
        ListNode slow_index = head;
        ListNode enter_index = head;
        if(head == null || fast_index.next == null || fast_index.next.next == null){
            return null;
        }
        fast_index = fast_index.next.next;
        slow_index = slow_index.next;
        while (fast_index!=slow_index){
            if(fast_index.next == null || fast_index.next.next == null){
                return null;
            }
            fast_index = fast_index.next.next;
            slow_index = slow_index.next;
        }

        while (enter_index!=slow_index){
            enter_index = enter_index.next;
            slow_index = slow_index.next;
        }

        return enter_index;
    }
}
class ListNode142 {
    int val;
    ListNode142 next;
    ListNode142(int x) {
        val = x;
        next = null;
    }
}