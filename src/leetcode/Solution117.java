package leetcode;

import java.util.*;

public class Solution117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
//        if(root ==null) return null;
//        //广度优先遍历
//        Deque<Node> dequeEven = new LinkedList<>();
//        Deque<Node> dequeOdd = new LinkedList<>();
//        dequeOdd.add(root);
//        boolean flag = false;
//        Node pre = new Node();
//        while (!dequeOdd.isEmpty() || !dequeEven.isEmpty()){
//            while(!dequeOdd.isEmpty()){
//                Node node = dequeOdd.poll();
//                if(node==null) break;
//                node.next = pre.next;
//                pre = node;
//                if(node.right!=null) dequeEven.add(node.right);
//                if(node.left!=null) dequeEven.add(node.left);
//            }
//            while(!dequeEven.isEmpty()){
//                Node node = dequeEven.poll();
//                if(node==null) break;
//                node.next = pre.next;
//                pre = node;
//                if(node.right!=null) dequeOdd.add(node.right);
//                if(node.left!=null) dequeOdd.add(node.left);
//            }
//            pre = null;
//        }
//        return root;
        //
        Queue<Node> queue = new LinkedList();
        if(root!= null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Node temp = queue.poll();
                temp.next = queue.peek();
                if(size==0){
                    temp.next=null;
                }
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }

        }
        return root;
    }
}

