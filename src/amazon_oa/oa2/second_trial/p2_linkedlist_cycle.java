package src.amazon_oa.oa2.second_trial;

import src.first_round.ListNode;

/**
 * Created by stameying on 2/27/16.
 */
public class p2_linkedlist_cycle {

    public static boolean detact_cycle(ListNode head){
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true; // detact a cycle
        }
        return false;
    }
}
