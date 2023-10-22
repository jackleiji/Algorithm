package jianzhioffer;

public class Solution29 {
    public Node insert(Node head, int insertVal) {
        if(head==null) {
            head=new Node(insertVal);
            head.next = head;
            return head;
        }else if(head.next.equals(head)){
            head.next = new Node(insertVal);
            head.next.next = head;
            return head;
        }
        //遍历循环链表找到适合的点插入
        Node indexStart= head;
        Node indexEnd= head;
        int count = 0;
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        //双指针
        while (true){
            if(indexStart.val<=insertVal && indexStart.next.val>=insertVal){
                Node temp = indexStart.next;
                indexStart.next = new Node(insertVal);
                indexStart.next.next = temp;
                break;
            }
            if(indexStart.val>maxVal){
                maxVal = indexStart.val;
            }
            if(indexStart.val<minVal){
                minVal = indexStart.val;
            }
            if(indexEnd.equals(indexStart)) count++;
            if(count==2){
                //未找到合适的位置
                if(insertVal<minVal || insertVal>maxVal){
                    if(maxVal==minVal || (indexStart.val==maxVal && indexStart.val!=indexStart.next.val)){
                        Node temp = indexStart.next;
                        indexStart.next = new Node(insertVal);
                        indexStart.next.next = temp;
                        break;
                    }
                }
            }
            indexStart = indexStart.next;
            indexEnd = indexEnd.next.next;
        }
        return head;
    }
}
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};