package leetcode;

import java.util.*;

public class Solution138 {
    //KEY:原链表，新链表
    Map<Node,Node> map = new LinkedHashMap<>();
    public Node copyRandomList(Node head) {
        //法一：递归回溯
        if(head==null) return null;

        if(!map.containsKey(head)){
            Node headNew = new Node(head.val);
            map.put(head,headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return map.get(head);
        //法二：遍历
//        Node index = head;
//        Node res = new Node(0);
//        Node resIndex = res;
//        LinkedList<Node> list1= new LinkedList<>();
//        LinkedList<Node> list2= new LinkedList<>();
//        //先复制主亮
//        while (index!=null){
//            resIndex.next = new Node(index.val);
//            System.out.println(resIndex.next.val);
//            list1.add(index);
//            list2.add(resIndex.next);
//            index = index.next;
//            resIndex = resIndex.next;
//        }
//        index = head;
//        resIndex = res.next;
//        while (index!=null){
//            if(index.random!=null){
//                resIndex.random = list2.get(list1.indexOf(index.random));
//            }
//            System.out.println(resIndex.next.val);
//            index = index.next;
//            resIndex = resIndex.next;
//        }
//        return res.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}