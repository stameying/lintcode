import java.util.HashMap;

/**
 * Created by stameying on 12/18/15.
 */
public class Copy_List_with_Random_Pointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    /*
    * Easy solution with HashMap but O(n) space complexity
    * */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        HashMap<Integer,RandomListNode> map = new HashMap<Integer,RandomListNode>();
        RandomListNode cur = head;
        while (cur != null){
            RandomListNode temp;
            if (map.containsKey(cur.label)){
                temp = map.get(cur.label);
            }
            else{
                temp = new RandomListNode(cur.label);
                map.put(cur.label,temp);
            }
            if (cur.next != null){
                if (map.containsKey(cur.next.label)){
                    temp.next = map.get(cur.next.label);
                }else{
                    RandomListNode tempnext = new RandomListNode(cur.next.label);
                    temp.next = tempnext;
                    map.put(cur.next.label,tempnext);
                }
            }
            if (cur.random != null){
                if (map.containsKey(cur.random.label)){
                    temp.random = map.get(cur.random.label);
                }else{
                    RandomListNode temprandom = new RandomListNode(cur.random.label);
                    temp.random = temprandom;
                    map.put(cur.random.label,temprandom);
                }
            }
            cur = cur.next;
        }
        return map.get(head.label);
    }

    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    /*
    * Better one with O(1) solution!
    * Taught in CSCI570 but didn't come up with it after looking at the solution online
    * http://tech-queries.blogspot.ca/2011/04/copy-linked-list-with-next-and-random.html
    * */
    public RandomListNode copyRandomList2(RandomListNode head) {
        // write your code here
        RandomListNode res, cur = head, next, tmp;

        // 1: A->B->C->null  =>  A->A'->B->B'->C->C'->null
        while (cur != null){
            tmp = new RandomListNode(cur.label);
            tmp.next = cur.next;
            next = cur.next;
            cur.next = tmp;
            cur = next;
        }

        // save result pointer
        res = head.next;

        cur = head;

        // copy random pointer
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // restore the original linked list and copied linked list
        cur = head;
        tmp = head.next;
        while (cur != null && tmp != null){
            cur.next = cur.next.next;
            cur = cur.next;
            if (tmp.next != null){
                tmp.next = tmp.next.next;
                tmp = tmp.next;
            }
        }

        return res;
    }



}
