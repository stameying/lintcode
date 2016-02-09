package Google_Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by stameying on 2/7/16.
 */
public class p28_random_queue {
    private List<Integer> queue;
    public p28_random_queue(){
        queue = new ArrayList<>();
    }

    public void enqueue(int val){
        queue.add(val);
    }

    public int dequeue(){
        Random r = new Random();
        int idx = r.nextInt(queue.size());
        System.out.println("idx = " + idx);
        int res = queue.get(idx);
        queue.set(idx, queue.get(queue.size()-1));
        queue.remove(queue.size()-1);
        return res;
    }


    public static void main(String[] args) {
        p28_random_queue random_queue = new p28_random_queue();
        random_queue.enqueue(2);
        random_queue.enqueue(3);
        random_queue.enqueue(4);
        random_queue.enqueue(7);
        random_queue.enqueue(2);
        System.out.println(random_queue.dequeue());
    }
}
