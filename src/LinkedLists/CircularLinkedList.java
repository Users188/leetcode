package LinkedLists;

import javax.swing.*;

/*leetcode:排序的有序循环链表*/
public class CircularLinkedList {
    static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head,int insertVal) {
        Node newNode=new Node(insertVal);
        //链表为空
        if (head==null){
            head=newNode;
            head.next=head;
            return head;
        }
        //链表只有一个结点
        if (head.next == null) {
            head.next=newNode;
            head.next.next=head;
            return head;
        }
        Node cur=head;
        //尝试在升序排列中插入
        do{
            if (cur.val<=insertVal&&cur.next.val>=insertVal){
                do_insert(cur,newNode);
                return head;
            }
            cur=cur.next;
        }while (cur!=head);
        //没有插入则在升序排列最后一个结点插入
        Node last=getLastMax(head);
        do_insert(last,newNode);
        return head;
    }

    private Node getLastMax(Node head){
        //获取升序排列最后一个结点
        Node cur=head;
        do {
            cur=cur.next;
        }while (cur!=head&&cur.next.val>=cur.val);
        return cur;
    }

    private void do_insert(Node head,Node node){
        Node next=head.next;
        head.next=node;
        node.next=next;
    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        node3.next=node4;
        node4.next=node1;
        node1.next=node3;
        CircularLinkedList.printList(node3);
        System.out.println();
        CircularLinkedList c=new CircularLinkedList();
        c.insert(node3,2);
        CircularLinkedList.printList(node3);
    }

    private static void printList(Node head){
        Node cur=head;
        do {
            System.out.print(cur.val+" ");
            cur=cur.next;
        }while (cur!=head);
    }
}
