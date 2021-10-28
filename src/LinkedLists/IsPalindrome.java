package LinkedLists;

import java.util.ArrayList;
import java.util.List;

/*leetcode:回文链表*/
/*给定一个链表的 头节点 head ，请判断其是否为回文链表。
如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。*/
public class IsPalindrome {
    public boolean isPalindrome(ListNode head){
        //将链表值转入数组解决
        if (head==null||head.next==null)
            return true;
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        int left=0,right=list.size()-1;
        while (left<right){
            if (!list.get(left).equals(list.get(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
