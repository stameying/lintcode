package src.amazon_oa.oa1;

import src.first_round.ListNode;

/**
 * Created by stameying on 2/25/16.
 */
public class reverse_second_half_linkedlist {

    public static ListNode reverse_second_half(ListNode head){
        if (head == null || head.next == null) return head; // no need to reverse
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = reverseList(slow);
        pre.next = secondHead;
        return head;
    }

    public static ListNode reverseList(ListNode head){
        ListNode tail = null, pre = tail, cur = head;
        while (cur != null){
            ListNode Next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = Next;
        }
        return pre;
    }


    public static void displayList(ListNode head){
        while (head != null ){
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
        ListNode rvalue = reverse_second_half(head);
        displayList(rvalue);

    }


}
