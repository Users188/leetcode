package LinkedLists;

/*leetcode:反转链表*/
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        //迭代实现
        if (head == null)
            return null;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList_recursion(ListNode head) {
        //递归实现
        //当head.next==null停止递进
        if (head==null||head.next==null)
            return head;
        ListNode last= reverseList_recursion(head.next);
        //对每个节点(除了last)进行如下操作
        head.next.next=head;
        head.next=null;
        return last;
    }
}
