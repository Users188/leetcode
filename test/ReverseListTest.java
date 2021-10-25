import LinkedLists.ListNode;
import LinkedLists.ReverseList;
import org.junit.jupiter.api.Test;

public class ReverseListTest {
    public ListNode LinkedLists(){
        ListNode node=new ListNode();
        ListNode head=node;
        for (int i = 0; i < 4; i++) {
            node.setNext(new ListNode(i));
            node=node.getNext();
        }
        return head.getNext();
    }
    public void printLinkedLists(ListNode head){
        while (head!=null){
            System.out.print(head.getVal()+" ");
            head=head.getNext();
        }
    }
    @Test
    public void reverseListTest(){
        ListNode head=LinkedLists();
        printLinkedLists(head);
        head=new ReverseList().reverseList_recursion(head);
        printLinkedLists(head);
    }
}
