public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        ListNode fast_index = head;
        ListNode slow_index = head;
        ListNode res = new ListNode();
        ListNode res_index = res;
        boolean flag = false;
        while (fast_index!=null){
            fast_index = fast_index.next;

            if(fast_index != null && slow_index.val == fast_index.val){
                flag = true;
            }
            if(fast_index==null || slow_index.val != fast_index.val){
                if(!flag){
                    res_index.next = new ListNode(slow_index.val);
                    res_index = res_index.next;
                }
                flag = false;
            }
            slow_index = slow_index.next;
        }

        return res.next;
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
