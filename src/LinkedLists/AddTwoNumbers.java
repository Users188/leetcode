package LinkedLists;

/*leetcode:将两个数字相加*/
/*给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。
它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
可以假设除了数字 0 之外，这两个数字都不会以零开头。*/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //翻转链表使其低位对齐
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        l1 = new ReverseList().reverseList(l1);
        l2 = new ReverseList().reverseList(l2);

        return new ReverseList().reverseList(addTwoNumbersFromUnits(l1, l2));
    }

    //从个位开始加
    public ListNode addTwoNumbersFromUnits(ListNode l1, ListNode l2) {
        //哨兵节点
        ListNode dummy = new ListNode();
        //指针
        ListNode pointer = dummy;
        //设置当前位置的和
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            pointer.next = new ListNode(sum % 10);
            pointer=pointer.next;
            sum = sum / 10;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        //最高位是否有进位
        if (sum>0)
            pointer.next = new ListNode(sum % 10);
        return dummy.next;
    }

}
