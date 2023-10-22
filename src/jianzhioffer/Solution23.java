package jianzhioffer;

public class Solution23 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode headAIndex = headA;
        ListNode headBIndex = headB;
        int count = 0;
        while (headAIndex==null||headBIndex==null||!headAIndex.equals(headBIndex)){
            if(headAIndex == null) count++;
            if(count==2) return null;
            headAIndex = headAIndex == null?headBIndex:headAIndex.next;
            headBIndex = headBIndex == null?headAIndex:headBIndex.next;
            if(headAIndex != null)
            System.out.println(headAIndex.val);
        }
        return headAIndex;
    }
}
