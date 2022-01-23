package LinkedLists;

import java.util.*;

/**
 * leetcode:合并排序链表
 * 给定一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class MergeKLists {
    //利用有序Map
    public ListNode mergeKLists_1(ListNode[] lists) {
        TreeMap<Integer, Queue<ListNode>> map = new TreeMap<>();
        for (ListNode list : lists) {
            while (list != null) {
                Queue<ListNode> nodes = map.getOrDefault(list.val, new ArrayDeque<>());
                nodes.add(list);
                map.put(list.val, nodes);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
        for (int i : map.keySet()) {
            Queue<ListNode> nodes = map.get(i);
            while (!nodes.isEmpty()) {
                pointer = pointer.next = nodes.poll();
            }
        }
        return dummy.next;
    }

    //最小堆
    public ListNode mergeKLists_2(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue =
                new PriorityQueue<>(Comparator.comparingInt((node) -> node.val));
        for (ListNode list : lists) {
            while (list != null) {
                priorityQueue.add(list);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
        while (!priorityQueue.isEmpty()) {
            pointer = pointer.next = priorityQueue.poll();
        }
        pointer.next = null;//断尾
        return dummy.next;
    }

    //归并排序
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeLists(lists, 0, lists.length);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start == end - 1)
            return lists[start];
        int mid = (start + end) >> 1;
        ListNode l1 = mergeLists(lists, start, mid);
        ListNode l2 = mergeLists(lists, mid, end);
        return merge(l1, l2);
    }

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
