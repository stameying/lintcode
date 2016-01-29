package EPI.stack_and_queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Created by stameying on 1/28/16.
 */
public class circular_queue {
    /**
     * Implement a queue with array, and a head and tail pointer
     * */
    int head = 0, tail = 0, numOfElement = 0;
    static final int SCLAE_FACTOR = 2;
    Integer[] entries;

    public circular_queue(int capacity){
        entries = new Integer[capacity];
    }

    public void enqueue(Integer num){
        if (numOfElement == entries.length){ // need to resize
            System.out.println("Before rotate = " + Arrays.toString(entries));
            Collections.rotate(Arrays.asList(entries),-head);
            System.out.println("After rotate = " + Arrays.toString(entries));
            //reset head
            head = 0;
            tail = numOfElement;
            entries = Arrays.copyOf(entries, numOfElement*SCLAE_FACTOR);
        }
        entries[tail] = num;
        tail = (tail+1)%entries.length;
        ++numOfElement;
    }

    public Integer dequeue(){
        if (numOfElement != 0){
            --numOfElement;
            Integer ret = entries[head];
            head = (head+1)%entries.length;
            return ret;
        }
        throw new NoSuchElementException("error");
    }

    public static void main(String[] args) {
        circular_queue queue = new circular_queue(3);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        queue.enqueue(6);
    }
}
