package Google_Topic;

import EPI.linkedlist.ListNode;

/**
 * Created by stameying on 2/10/16.
 */
public class p89_generate_string {

    public static ListNode generateNumber(String s){
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead, newNode = new ListNode(1), lastNode = prev;
        prev.next = newNode;
        prev = newNode;
        for (int i = 0; i < s.length(); i++){
            ListNode node = new ListNode(i+2);
            if (s.charAt(i) == 'i'){
                prev.next = node;
                lastNode = prev;
                prev = node;
            }else{
                ListNode next = lastNode.next;
                lastNode.next = node;
                node.next = next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = generateNumber("iddid");
        while (head != null){
            System.out.print(head.val+ (head.next!=null?"->":""));
            head = head.next;
        }
    }
}
