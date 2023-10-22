package leetcode.solution;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode index = head;
        while (index!=null){
            sb.append(index.val);
            index = index.next;
        }
        System.out.println(sb+" "+sb.reverse());
        return sb.equals(sb.reverse());
    }
}
