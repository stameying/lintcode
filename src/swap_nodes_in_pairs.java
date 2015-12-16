/**
 * Created by stameying on 12/15/15.
 */
public class swap_nodes_in_pairs {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        ListNode DummyHead = new ListNode(0), prev = DummyHead, cur = head;
        DummyHead.next = head;
        while (cur != null && cur.next != null){
            // swap
            ListNode nextCur = cur.next.next;
            ListNode next = cur.next;
            prev.next = next;
            next.next = cur;
            cur.next = nextCur;
            prev = cur;
            cur = nextCur;
        }
        return DummyHead.next;
    }
}
