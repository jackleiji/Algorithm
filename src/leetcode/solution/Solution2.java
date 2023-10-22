package leetcode.solution;


public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        if(l1 == null) return l2;
        else if(l2 == null) return l1;

        ListNode l1_index = l1;
        ListNode l2_index = l2;
        ListNode res_index = res;

        int flag = 0;

        while (l1_index != null && l2_index != null){
            res_index.next = new ListNode();
            res_index = res_index.next;
            int add_sum = l1_index.val+l2_index.val+flag;
            res_index.val = add_sum%10;
            flag = add_sum/10;


            l1_index = l1_index.next;
            l2_index = l2_index.next;
        }
        int add_sum = 0;
        while(l2_index!=null){
            res_index.next = new ListNode();
            res_index = res_index.next;
            add_sum = flag+l2_index.val;
            res_index.val = add_sum%10;
            flag = add_sum/10;
            l2_index = l2_index.next;
        }
        while (l1_index != null){
            res_index.next = new ListNode();
            res_index = res_index.next;
            add_sum = flag+l1_index.val;
            res_index.val = add_sum%10;
            flag = add_sum/10;
            l1_index = l1_index.next;
        }

        if(flag!=0){
            res_index.next = new ListNode();
            res_index = res_index.next;
            res_index.val = flag;
        }

        return res.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
}
