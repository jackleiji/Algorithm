package jianzhioffer;

import java.util.*;

public class Solution25 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode indexl1 = l1;
        ListNode indexl2 = l2;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (indexl1!=null&&indexl2!=null){
            stack1.push(indexl1.val);
            stack2.push(indexl2.val);
            indexl1 = indexl1.next;
            indexl2 = indexl2.next;
        }
        while (indexl1!=null){
            stack1.push(indexl1.val);
            indexl1 = indexl1.next;
        }
        while (indexl2!=null){
            stack2.push(indexl2.val);
            indexl2 = indexl2.next;
        }
        ListNode res = new ListNode();
        boolean flag = false;

        while (!stack1.isEmpty()&&!stack2.isEmpty()){
            int v = flag?stack1.pop()+ stack2.pop()+1:stack1.pop()+ stack2.pop();
            ListNode temp = res.next;
            res.next = new ListNode(v%10);
            flag=false;
            res.next.next = temp;
            if(v/10!=0){
                flag = true;
            }
        }
        while (!stack1.isEmpty()){
            int v = flag?stack1.pop()+1 :stack1.pop();
            ListNode temp = res.next;
            res.next = new ListNode(v%10);
            flag=false;
            res.next.next = temp;
            if(v/10!=0){
                flag = true;
            }
        }
        while (!stack2.isEmpty()){
            int v = flag?stack2.pop()+1:stack2.pop();
            ListNode temp = res.next;
            res.next = new ListNode(v%10);
            flag=false;
            res.next.next = temp;
            if(v/10!=0){
                flag = true;
            }
        }
        if(flag){
            ListNode temp = res.next;
            res.next = new ListNode(1);
            res.next.next = temp;
        }
        return res.next;
    }
}
