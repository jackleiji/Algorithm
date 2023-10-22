package leetcode;

import java.util.Deque;
import java.util.LinkedList;


public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        Deque<ListNode> queue = new LinkedList<>();
        ListNode index = head;
        while (index!=null){
            queue.add(index);
            index = index.next;
        }
        ListNode reverse = new ListNode();
        ListNode r_index = reverse;

        while (!queue.isEmpty()){

            r_index.next = new ListNode(queue.pollLast().val);
            System.out.println(r_index.val);
            r_index = r_index.next;
        }
        return reverse.next;
    }
}
