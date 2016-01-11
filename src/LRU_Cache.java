import java.util.HashMap;

/**
 * Created by stameying on 1/10/16.
 */
public class LRU_Cache {
    // @param capacity, an integer
    doubleLinkedNode head;
    doubleLinkedNode tail;
    HashMap<Integer,doubleLinkedNode> map;
    int capacity;
    public LRU_Cache(int capacity) {
        // write your code here
        map = new HashMap<Integer,doubleLinkedNode>();
        head = new doubleLinkedNode(Integer.MIN_VALUE,Integer.MIN_VALUE);
        tail = new doubleLinkedNode(Integer.MAX_VALUE,Integer.MAX_VALUE);
        this.capacity = capacity;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)){
            printList();
            return -1;
        }
        else{
            int val = map.get(key).value;
            cacheHot(map.get(key));
//            printList();
            return val;
        }
    }

    public void cacheHot(doubleLinkedNode node){
        if (head.next.key == node.key) return; // already the first obj in cache
        doubleLinkedNode prevNode = node.prev;
        if (tail.next.key == node.key){ // handle tail
            System.out.println("!!!! prev=" + prevNode.key);
            tail.next = prevNode;
            prevNode.next = null;
        }else{
            prevNode.next = node.next;
            node.next.prev = prevNode;
        }
        // move node to front
        doubleLinkedNode originHeadNode = head.next;
        originHeadNode.prev = node;
        node.next = originHeadNode;
        node.prev = null;
        head.next = node;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
//        System.out.println("map size="+map.size());
        if (map.containsKey(key)){
            map.get(key).value = value;
            cacheHot(map.get(key));
        }else{
            if (map.size() == this.capacity){
                map.remove(tail.next.key);
                if (tail.next.prev != null){
                    tail.next.prev.next = null;
                    tail.next = tail.next.prev;
                }else{
                    // only one node
                    head.next = null;
                    tail.next = null;
                }
                set(key,value);
                return;
            }else{
                if (map.size() == 0){
                    // empty
                    doubleLinkedNode node = new doubleLinkedNode(key,value);
                    map.put(key, node);
                    head.next = node;
                    tail.next = node;
                }else{
                    doubleLinkedNode node = new doubleLinkedNode(key,value);
                    map.put(key, node);
                    doubleLinkedNode originalHeadNode = head.next;
                    originalHeadNode.prev = node;
                    node.next = originalHeadNode;
                    head.next = node;
                }
            }
        }
        printList();
    }

    public void printList(){
        doubleLinkedNode cur = head;
        while (cur != null){
            System.out.print(cur.key);
            if (cur.next != null) System.out.print("->");
            cur = cur.next;
        }

        cur = tail.next;
        String display = "<-2147483648";
        System.out.println();
        while (cur != null){
            display = cur.key + display;
            if (cur.prev != null) display = "<-" + display;
            cur = cur.prev;
        }
        System.out.print(display);

        System.out.print("; head->"+head.next.key + "; tail->"+tail.next.key);
        System.out.println();
    }

    public static void main(String[] args) {
        LRU_Cache test = new LRU_Cache(3);
        test.set(1,1);
        test.set(2,2);
        test.set(3,3);
        test.set(4,4);
        System.out.println(test.get(2));
        test.printList();
        System.out.println(test.get(4));
        System.out.println(test.get(3));
        System.out.println(test.get(2));
        System.out.println(test.get(1));
        test.set(5,5);
        System.out.println(test.get(1));
        System.out.println(test.get(2));
        System.out.println(test.get(3));
        System.out.println(test.get(4));
        System.out.println(test.get(5));
    }
}

class doubleLinkedNode{
    doubleLinkedNode prev,next;
    int key,value;
    public doubleLinkedNode(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}
