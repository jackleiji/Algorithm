package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution160 {
    public static void main(String[] args) {

    }
    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            List<ListNode> list = new LinkedList<ListNode>();
            ListNode indexA = headA;
            ListNode indexB = headB;
            while (indexA!=null){
                list.add(indexA);
                indexA = indexA.next;
            }

            while (indexB!= null){
                if(list.contains(indexB)){
                    return indexB;
                }else{
                    indexB = indexB.next;
                }

            }
            return null;
        }

    }
}
