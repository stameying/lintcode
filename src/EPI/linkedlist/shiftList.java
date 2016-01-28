package EPI.linkedlist;

/**
 * Created by stameying on 1/27/16.
 */
public class shiftList {

    public static ListNode shift(ListNode head, int k){
        if (head == null) return head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null){
            len++;
            tail = tail.next;
        }
        k %= len;
        if (k == 0) return head;

        tail.next = head;
        int stepToNewHead = len-k;
        ListNode newTail = tail;
        while (stepToNewHead-- > 0){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
