package src.amazon_oa.oa2.second_trial;

import src.first_round.ListNode;

/**
 * Created by stameying on 2/27/16.
 */
public class p3_start_of_cycle {

    public static ListNode start_of_cycle(ListNode head){
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break; // there is a cycle
        }
        if (fast == null || fast.next == null) return null; //no cycle
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
