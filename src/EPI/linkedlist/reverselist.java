package EPI.linkedlist;

/**
 * Created by stameying on 1/27/16.
 */
public class reverselist {

    static ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
