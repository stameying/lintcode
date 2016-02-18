package src.first_round;

/**
 * Created by stameying on 12/22/15.
 */
public class lengthOfListNode {

    public static int getLen(ListNode head){
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        System.out.println(getLen(node1));
    }
}
