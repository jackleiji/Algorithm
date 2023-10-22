package jianzhioffer;

public class Solution28 {
    public Node flatten(Node head) {
        Node res = flattenNode(head);
        while (res.prev!=null){
            if(res.child!=null) res.child=null;
            res = res.prev;
        }
        return res;
    }
    public Node flattenNode(Node head) {
        //深度优先
        if (head==null) return null;
        Node indexHead2 = head;
        Node indexHead = indexHead2;
        while (indexHead2!=null){
            Node indexNext = indexHead2.next;
            System.out.println(indexHead2.val);
            if(indexHead2.child!=null){
                Node resChild = indexHead2.child;
                Node childNodeEnd = flattenNode(resChild);
                indexHead2.next = resChild;
                resChild.prev = indexHead2;
                indexHead2.child = null;
                //
                if(indexNext!= null && childNodeEnd!=null){
                    indexNext.prev = childNodeEnd;
                    childNodeEnd.next = indexNext;
                    indexHead2 = indexNext;
                }else if(indexNext== null && childNodeEnd!=null){
                    return childNodeEnd;
                }
            }
            indexHead = indexHead2;
            indexHead2 = indexNext;
        }
        return indexHead;
    }
    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
