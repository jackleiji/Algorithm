package leetcode.solution;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode big_list = new ListNode();
        ListNode small_list = new ListNode();
        if(list1==null && list2==null) return list1;
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val>=list2.val) {
            big_list = list1;
            small_list = list2;
        }else{
            big_list = list2;
            small_list = list1;
        }
        ListNode big_index = big_list;
        ListNode small_index = small_list;

        while (big_index!=null&&small_index!=null){
            ListNode temp = new ListNode();
//            if(small_index!=null || big_index!=null ) break;
            while (small_index.val<=big_index.val ||(small_index.next!=null && small_index.next.val<big_index.val)){
                System.out.println(small_index.val);
                temp = small_index;
                small_index = small_index.next;
            }
            small_index = temp;
            if(small_index.val<=big_index.val){
                temp = big_index;
                big_index = big_index.next;
                ListNode small_temp = small_index.next;
                small_index.next = temp;
                small_index = small_index.next;
                small_index.next = small_temp;
            }

        }
        if(big_index!=null){
            small_index.next = big_index;
        }
        return small_index;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}