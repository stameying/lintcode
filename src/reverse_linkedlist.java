/**
 * Created by stameying on 12/14/15.
 */
public class reverse_linkedlist {
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode dummyHead = null, prev = dummyHead, cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
