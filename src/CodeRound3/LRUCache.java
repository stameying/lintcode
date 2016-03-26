package src.CodeRound3;

import java.util.HashMap;

/**
 * Created by stameying on 3/23/16.
 */
public class LRUCache {

    private static class Node {
        public Node pre, next;
        public int key;
        public int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    public Node head, tail;
    public HashMap<Integer, Node> map;
    public int capacity;

    public LRUCache(int capacity) {
        // 一个double linkedlist
        // 一个Map<Key,对应的node>
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            int res = map.get(key).val;
            removeNode(map.get(key));
            addToFront(map.get(key));
            return res;
        }
    }

    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            // 不存在
            Node node = new Node(key, value);
            map.put(key, node);
            addToFront(node);
            if (map.size() > capacity) {
                Node tailNode = this.tail;
                removeNode(tailNode);
                System.out.println("tailNode node to remove is " + tailNode.key);
                map.remove(tailNode.key);
            }
        } else {
            // 存在了
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToFront(node);
        }
    }

    public void addToFront(Node node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            Node preHead = this.head;
            this.head = node;
            node.next = preHead;
            preHead.pre = node;
        }
    }

    public void removeNode(Node node) {
        if (node == this.head) {
            if (node == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                Node nextHead = this.head.next;
                this.head = nextHead;
                nextHead.pre = null;

            }
        } else if (node == this.tail) {
            Node preNode = this.tail.pre;
            this.tail = preNode;
            preNode.next = null;
        } else {
            Node preNode = node.pre;
            Node nextNode = node.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;

        }
    }


    public void printList() {
        Node cur = head;
        while (cur != null){
            System.out.print(cur.key+"->");
            cur = cur.next;
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(2,1);

        cache.set(1,1);
        cache.get(2);
        cache.set(4,1);
        cache.get(1);
//        cache.get(2);
//        cache.printList();
        cache.printList();
    }
}
