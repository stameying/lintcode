package src.amazon_oa;

import src.first_round.ListNode;

/**
 * Created by stameying on 2/25/16.
 */
public class merge_two_sorted_list {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummyHead = new ListNode(0), pre = dummyHead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){ //注意这里可能是.value 不是val
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 != null) pre.next = l1;
        if (l2 != null) pre.next = l2;
        return dummyHead.next;
    }


}
