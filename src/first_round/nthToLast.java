package src.first_round;

/**
 * Created by stameying on 12/14/15.
 */
public class nthToLast {
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        // slow and fast head
        ListNode slow = head, fast = head;
        for (int i = 0 ; i < n; i++){
            if (fast != null){
                fast = fast.next;
            }else{
                // this should not happen since in the question it says the minimum number of nodes in list is n
                return head;
            }
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
