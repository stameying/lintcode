package EPI.linkedlist;

/**
 * Created by stameying on 1/28/16.
 */
public class list_pivoting {

    public static ListNode pivot(ListNode head, int k){
        ListNode lessHead = new ListNode(0);
        ListNode equalHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode cur = head, lessIter = lessHead, equalIter = equalHead, greaterIter = greaterHead;
        while (cur != null){
            if (cur.val < k){
                lessIter.next = cur;
                lessIter = cur;
            }else if (cur.val == k){
                equalIter.next = cur;
                equalIter = cur;
            }else{
                greaterIter.next = cur;
                greaterIter = cur;
            }
            cur = cur.next;
        }
        lessIter.next = equalHead.next;
        equalIter.next = greaterHead.next;
        greaterIter.next = null;
        return lessHead.next;
    }

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(3);
    }
}
