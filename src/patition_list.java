/**
 * Created by stameying on 12/14/15.
 */
public class patition_list {
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
        sec.next = null;
        return firstHead.next;
    }

    public static void main(String[] args) {

    }
}
