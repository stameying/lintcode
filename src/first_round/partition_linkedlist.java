package src.first_round;

/**
 * Created by stameying on 12/20/15.
 */
public class partition_linkedlist {

    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null || head.next == null) return head;
        ListNode firstHead = new ListNode(0), secHead = new ListNode(0), cur = head, first = firstHead, sec = secHead;
        while (cur != null){
            if (cur.val < x){
                first.next = cur;
                first = first.next;
            }else{
                sec.next = cur;
                sec = sec.next;
            }
            cur = cur.next;
        }
        first.next = secHead.next;
        // sec.next = null;
        return firstHead.next;

    }

    public static void main(String[] args) {

        partition_linkedlist test = new partition_linkedlist();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        ListNode newhead = test.partition(node1,3);
        int count = 0;
        while (newhead != null && count < 20){
            System.out.print(newhead.val + "->");
            newhead = newhead.next;
            count++;
        }
    }
}
