package src.amazon_oa;

import src.first_round.ListNode;

/**
 * Created by stameying on 2/25/16.
 */
public class linklistloop {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false; // base case
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }


    /**
     * 找到开始的
     * */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null; // base case
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ll";
        System.out.println(s1.indexOf(s2));
    }
}
