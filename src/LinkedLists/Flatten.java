package LinkedLists;
/*leetcode:扁平化多级链表*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Flatten {
    static class Node{
        int val;
        Node prev;
        Node next;
        Node child;
    }
    public Node flatten(Node head){
        Node pointer=head;
        Deque<Node> nexts=new ArrayDeque<>();
        while (pointer.next!=null||pointer.child!=null){
            if (pointer.child!=null){
                if(pointer.next!=null)
                    nexts.push(pointer.next);
                pointer.next=pointer.child;
                pointer.next.prev=pointer;
                pointer.child=null;
            }
            pointer=pointer.next;
        }
        while (!nexts.isEmpty()){
            Node pop=flatten(nexts.pop());
            pointer.next=pop;
            pop.prev=pointer;
            pointer=getLast(pop);
        }
        return head;
    }

    public Node getLast(Node head){
        while (head.next!=null){
            head=head.next;
        }
        return head;
    }
}
