package LinkedLists;
/*leetcode:链表中环的入口节点*/
/*给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数*/

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
    public ListNode detectCycle_primitive(ListNode head) {
        //利用hashset存贮遍历过的节点，如果遇到重复则为环的入口
        if (head == null)
            return null;
        Set<ListNode> nodes = new HashSet<>();
        ListNode pointer = head;
        while (pointer.next != null && !nodes.contains(pointer)) {
            nodes.add(pointer);
            pointer = pointer.next;
        }
        //链表无环
        if (pointer.next == null)
            return null;
        else
            return pointer;
    }

}
