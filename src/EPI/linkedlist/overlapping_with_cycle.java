package EPI.linkedlist;

/**
 * Created by stameying on 1/27/16.
 */
public class overlapping_with_cycle {

    public ListNode overlappingLists(ListNode l1, ListNode l2){
        ListNode root1 = hasCycle(l1);
        ListNode root2 = hasCycle(l2);

        if (root1 == null && root2 == null){
            return overlappingNoCycleLists(l1,l2);
        }else if ( (root1 == null && root2 != null) || (root1 != null && root2 == null)){
            // only one list has cycle
            return null;
        }else{
            //both have cycles
            ListNode temp = root2;
            do{
                temp = temp.next;
            }while(temp != root1 && temp != root2);

            if (temp != root1){
                return null; // cycles are disjoint
            }

            int stem1Length = distance(l1,root1), stem2Length = distance(l2,root2);
            int count = Math.abs(stem1Length-stem2Length);
            if (stem1Length > stem2Length){
                l1 = advanceListByK(count,l1);
            }else{
                l2 = advanceListByK(count,l2);
            }
            while (l1 != l2 && l1 != root1 && l2 != root2){
                l1 = l1.next;
                l2 = l2.next;
            }

            return l1==l2?l1:root1;
        }
    }


    private static int distance(ListNode l1, ListNode l2){
        int dis = 0;
        while (l1 != l2){
            l1 = l1.next;
            dis++;
        }
        return dis;
    }

    private static ListNode advanceListByK(int count, ListNode node){
        do{
            node = node.next;
        }while(count-- > 0);
        return node;
    }

    private ListNode overlappingNoCycleLists(ListNode l1, ListNode l2){
        int len1 = length(l1), len2 = length(l2);
        if (len1 > len2){
            l1 = advanceListByK(len1-len2,l1);
        }else{
            l2 = advanceListByK(len2-len1,l2);
        }
        while(l1 != l2 && l1 != null && l2 != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }

    private ListNode hasCycle(ListNode node){
        if (node == null || node.next == null) return null;
        ListNode slow = node, fast = node;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return slow;
        }
        return null;
    }

    private int length(ListNode l){
        int count = 0;
        while (l != null){
            l = l.next;
            count++;
        }
        return count;
    }

}
