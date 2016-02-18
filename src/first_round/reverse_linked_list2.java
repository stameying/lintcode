package src.first_round;

/**
 * Created by stameying on 12/20/15.
 */
public class reverse_linked_list2 {

    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode dummyHead = new ListNode(0), prev = dummyHead, cur = head;
        dummyHead.next = head;
        int count = 1;
        while (count < m){
            prev = cur;
            cur = cur.next;
            count++;
        }
        ListNode firstPrev = prev, reverseHead = cur;
        while (count < n){
            cur = cur.next;
            count++;
        }
        ListNode secondHead = cur.next;
        cur.next = null;
        firstPrev.next = reverseList(reverseHead);
        reverseHead.next = secondHead;
        return dummyHead.next;
    }

    public ListNode reverseList(ListNode head){
        ListNode dummy = null, cur = head;
        while ( cur != null){
            ListNode next = cur.next;
            cur.next = dummy;
            dummy = cur;
            cur = next;
        }
        return dummy;
    }
}
