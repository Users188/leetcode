package LinkedLists;
/*给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。*/

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd_primitive(ListNode head,int n){
        ListNode temp=head;
        int length=1;
        //得到链表长度
        while (temp.next!=null) {
            temp = temp.next;
            length++;
        }
        temp=head;
        for (int i = 0; i <= length-n; i++) {
            //如果要删除头结点，由于头结点无前驱结点，直接返回其后继结点。
            if (length-n==0)
                return head.next;
            //将要删除的结点的前驱结点的指针指向其后继结点
            if (i==length-n-1){
                temp.next=temp.next.next;
            }
            else
                temp=temp.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head,int n){
        //使用双指针
        //trick:设置哨兵结点（头结点的前驱结点，其值为空），使头节点无需单独考虑
        if (head==null)
            return null;
        ListNode new_head=new ListNode(0,head);
        ListNode theEnd=new_head;
        ListNode delete=new_head;
        for (int i = 0; i < n; i++) {
            theEnd=theEnd.next;
        }
        while (theEnd.next!=null){
            delete=delete.next;
            theEnd=theEnd.next;
        }
        delete.next=delete.next.next;
        return new_head.next;
    }

    //转化题意：删除相对于最后一个结点第n位的结点的后继结点
    static class ListNode {
        int value;
        ListNode next;

        ListNode() {

        }

        ListNode(int value) {
            this.value = value;
        }

        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
