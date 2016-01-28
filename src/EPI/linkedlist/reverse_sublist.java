package EPI.linkedlist;

/**
 * Created by stameying on 1/27/16.
 */
public class reverse_sublist {

    static ListNode reverseSub(ListNode head, int start, int finish){
        if (start == finish) return head;
        ListNode dummyHead = new ListNode(0), pre = dummyHead, cur = head;
        dummyHead.next = head;
        int i = 1;
        while (i != start){
            pre = cur;
            cur = cur.next;
            i++;
        }
        int len = finish-start+1;
        i = 0;
        pre.next = null;
        ListNode tempHead = null, temp = tempHead;
        while (i < len){
            ListNode next = cur.next;
            cur.next = temp;
            temp = cur;
            cur = next;
        }
        pre.next = temp;
        tempHead.next = cur;
        return dummyHead.next;
    }
}
