package LinkedLists;

//转化题意：删除相对于最后一个结点第n位的结点的后继结点
class ListNode {
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
