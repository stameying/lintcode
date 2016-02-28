package src.amazon_oa.oa2.second_trial;

import src.first_round.ListNode;

/**
 * Created by stameying on 2/28/16.
 */
public class p14_insert_into_list {

    public static ListNode insertList(ListNode head, int val){
        if (head == null){
            ListNode temp = new ListNode(val);
            temp.next = temp;
            return temp;
        }
        ListNode cur = head;

        do{
            if (val <= cur.next.val && val >= cur.val) break;
            if (cur.val > cur.next.val && (val < cur.next.val || val > cur.val)) break; // tail
            cur = cur.next;
        } while (cur != head);

        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        return newNode;
    }



    public ListNode Solution(ListNode head, int val) {
        if (head == null) {
            ListNode rvalue = new ListNode(val);
            rvalue.next = rvalue;
            return rvalue;
        }

        ListNode cur = head;

        do {
            if (val <= cur.next.val && val >= cur.val)	break;
            if (cur.val > cur.next.val && (val < cur.next.val || val > cur.val))	break;
            cur = cur.next;
        } while (cur != head);

        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        return newNode;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        int[] array = new int[] {2,4,6};
        for (int i = 0; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = head;

        ListNode res = insertList(head,2);
        cur = res;
        for (int i = 0; i <= array.length + 1; i++) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

        System.out.println();

//        p14_insert_into_list solution11 = new p14_insert_into_list();
//        ListNode rvalue = solution11.Solution(head, 7);
//        cur = rvalue;
//        for (int i = 0; i <= array.length + 1; i++) {
//            System.out.print(cur.val + " ");
//            cur = cur.next;
//        }
    }

}
