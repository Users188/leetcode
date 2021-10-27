package LinkedLists;

/*leetcode:重排链表*/
public class ReorderList {
    public void reorderList(ListNode head){
        ListNode l1=head;
        ListNode middleNode=getMiddleNode(head);
        //l2为后半部分的翻转（不包括middle）
        ListNode l2=new ReverseList().reverseList(getMiddleNode(middleNode.next));
        //使l1只剩前半部分
        middleNode.next=null;
        mergeList(l1,l2);
    }

    public ListNode getMiddleNode(ListNode head){
        ListNode fast,slow;
        fast=head;
        slow=head;
        //快指针一次走两步，慢指针一次走一步，当快指针到达链表终点时，慢指针在链表中间
        while (fast!=null&&fast.next!=null){
            fast= fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public void mergeList(ListNode l1,ListNode l2){
        //将两个链表合并
        while (l1.next!=null&&l2.next!=null){
            ListNode node1=l1.next;
            ListNode node2=l2.next;
            l1.next=l2;
            l1=node1;
            l2.next=l1;
            l2=node2;
        }

    }

}
