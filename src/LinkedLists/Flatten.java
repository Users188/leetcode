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
        if(head==null)
            return null;
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
            Node pop=nexts.pop();
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

    public Node dfs(Node node){
        //深度优先搜索
        Node cur=node;
        //记录链表的最后一个结点
        Node last=null;
        while (cur!=null){
            Node next=cur.next;
            if (cur.child!=null){
                //递归找到最后一个child(当child==null时返回)
                Node childLast=dfs(cur.child);
                cur.next=cur.child;
                cur.child.prev=cur;
                if (next!=null){
                    childLast.next=next;
                    next.prev=childLast;
                }
                cur.child=null;
                last=childLast;
            }
            else
                last=cur;
            cur=next;
        }
        return last;
    }
}
