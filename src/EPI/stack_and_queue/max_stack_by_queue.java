package EPI.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by stameying on 1/28/16.
 */
public class max_stack_by_queue {
    Deque<Integer> element = new LinkedList<>();
    Deque<MaxWithCount> cachedMaxWithCount = new LinkedList<>();
    public max_stack_by_queue(){

    }

    public Integer max(){
        if (empty()) throw new IllegalStateException("max(): empty stack");
        return cachedMaxWithCount.peekFirst().max;
    }

    public Integer pop(){
        Integer popElement = element.removeFirst();
        if (popElement.equals(cachedMaxWithCount.peekFirst().max)){
            cachedMaxWithCount.peekFirst().count-=1;
            if (cachedMaxWithCount.peekFirst().count == 0) cachedMaxWithCount.removeFirst();
        }
        return popElement;
    }

    public void push(Integer x){
        element.addFirst(x);
        if (!cachedMaxWithCount.isEmpty()){
            if (Integer.compare(x,cachedMaxWithCount.peekFirst().max) == 0){
                cachedMaxWithCount.peekFirst().count+=1;
            }
            else if (Integer.compare(x,cachedMaxWithCount.peekFirst().max) > 0){
                cachedMaxWithCount.addFirst(new MaxWithCount(x,1));
            }
        }else{
            cachedMaxWithCount.addFirst(new MaxWithCount(x,1));
        }
    }

    public boolean empty(){
        return element.isEmpty();
    }

    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        queue.addFirst(1);
        queue.addFirst(2);
        System.out.println(queue.removeFirst());
    }
}

class MaxWithCount{
    public Integer max;
    public Integer count;

    public MaxWithCount(Integer max, Integer count) {
        this.max = max;
        this.count = count;
    }
}
