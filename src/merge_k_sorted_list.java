import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by stameying on 12/29/15.
 */
public class merge_k_sorted_list {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        while (true){
            System.out.println("size="+lists.size());
            ListNode candidateHead = null;
            int candidateValue = Integer.MAX_VALUE;
            int candidatePos = -1;
            List<Integer> removeList = new ArrayList<Integer>();
            for (int i = 0; i < lists.size(); i++){
                if (lists.get(i) == null){
                    removeList.add(i);
                }else{
                    if (candidateHead == null){
                        candidateHead = lists.get(i);
                        candidateValue = lists.get(i).val;
                        candidatePos = i;
                    }else{
                        if (lists.get(i).val < candidateValue){
                            candidateHead = lists.get(i);
                            candidateValue = lists.get(i).val;
                            candidatePos = i;
                        }
                    }
                }
            }
            pre.next = candidateHead;
            if (candidateHead != null) candidateHead = candidateHead.next;
            pre = pre.next;
            if (candidatePos != -1) lists.set(candidatePos,candidateHead);
            else break;
        }
        return dummyHead.next;
    }

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists2(List<ListNode> lists) {
        // write your code here
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                if (a.val < b.val) return -1;
                else if (a.val > b.val) return 1;
                else return 0;
            }
        });
        for (ListNode node: lists){
            if (node != null) queue.offer(node);
        }

        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;

        while (queue.size() > 0){
            ListNode temp = queue.poll();
            pre.next = temp;
            if (temp.next != null) queue.offer(temp.next);
            pre = pre.next;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        merge_k_sorted_list test = new merge_k_sorted_list();
        ListNode head = new ListNode(2);
        ListNode head1 = new ListNode(-1);
        List<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        list.add(null);
        list.add(head1);
        test.mergeKLists(list);
    }
}
