package LinkedLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * leetcode: 链表排序
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortList {
    public ListNode sortList_1(ListNode head) {
        PriorityQueue<ListNode> nodePriorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        while (head != null) {
            nodePriorityQueue.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
        while (!nodePriorityQueue.isEmpty()) {
            pointer.next = nodePriorityQueue.poll();
            pointer = pointer.next;
        }
        pointer.next = null;//防止出现循环
        return dummy.next;
    }

    public ListNode sortList_2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
        Collections.sort(list);
        for (int num : list) {
            pointer.next = new ListNode(num);
            pointer = pointer.next;
        }
        return dummy.next;
    }

    //归并排序递归
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode head1 = head;
        ListNode head2 = split(head);
        head1 = sortList(head1);
        head2 = sortList(head2);
        return merge(head1, head2);
    }

    //快慢指针找链表中点
    private ListNode split(ListNode head) {
        ListNode fast = head.next;//注意:不能改成等于head，需要返回靠前的中点（偶数长度）来断尾
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;//断尾
        return mid;
    }

    //合并两个链表
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                pointer = pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer = pointer.next = head2;
                head2 = head2.next;
            }
        }
        //给定的两个链表长度最多只差一个节点
        if (head1 != null) pointer.next = head1;
        if (head2 != null) pointer.next = head2;
        return dummy.next;
    }


}
