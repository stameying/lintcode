package EPI.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by stameying on 1/28/16.
 */
public class max_queue<T extends Comparable<T>>{
    private Queue<T> entries = new LinkedList<>();
    private Queue<T> candidatesForMax = new LinkedList<>();
    public max_queue() {
    }

    // 入队
    public void enqueue(T x){
        entries.offer(x);
        while (!candidatesForMax.isEmpty()){
            if (candidatesForMax.peek().compareTo(x) >= 0) break;
            candidatesForMax.poll();
        }
        candidatesForMax.offer(x);
    }

    // 出队
    public T dequeue(){
        if (!entries.isEmpty()){
            T result = entries.poll();
            if (result.equals(candidatesForMax.peek())) candidatesForMax.poll();
            return result;
        }
        throw new NoSuchElementException("empty");
    }

    public T max(){
        return candidatesForMax.peek();
    }
}
