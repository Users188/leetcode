package LinkedLists;

import java.util.HashSet;
import java.util.Set;

/*leetcode:两个链表的第一个重合点*/
public class InterSectionNode {
    public ListNode getInterSectionNode(ListNode headA,ListNode headB){
        Set<ListNode> nodesA=new HashSet<>();
        //将链表A的节点全部存到集合中
        while (headA!=null){
            nodesA.add(headA);
            headA=headA.next;
        }
        //查询链表B的节点是否在集合中，如果在，则说明有重合
        while (headB!=null){
            if (nodesA.contains(headB))
                return headB;
            headB=headB.next;
        }
        return null;
    }
}
