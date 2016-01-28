package EPI.linkedlist;

/**
 * Created by stameying on 1/28/16.
 */
public class add_sum {

    public static ListNode node_sum(ListNode node1, ListNode node2){
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode dummyHead = new ListNode(0), pre = dummyHead, cur1 = node1, cur2 = node2;
        int carry = 0;
        while (cur1 != null || cur2 != null){
            int sum = carry;
            if (cur1!=null){
                sum+=cur1.val;
                cur1=cur1.next;
            }
            if (cur2!=null){
                sum+=cur2.val;
                cur2=cur2.next;
            }
            pre.next = new ListNode(sum%10);
            carry=sum/10;
            pre=pre.next;
        }
        if (carry == 1) pre.next = new ListNode(1);
        return dummyHead.next;
    }
}
