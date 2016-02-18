package src.first_round;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by stameying on 1/7/16.
 */
public class ugly_number {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    // using priority queue
    public long kthPrimeNumber(int k) {
        // write your code here
        long number = 0;
        Queue queue = new PriorityQueue<Long>();
        queue.offer(3);
        queue.offer(5);
        queue.offer(7);
        for (int i = 0; i < k; i++){
            number = (long)queue.poll();
            if (number % 3 == 0){
                queue.offer(number*3);
            }else if (number % 5 == 0){
                queue.offer(number*3);
                queue.offer(number*5);
            }else{
                queue.offer(number*3);
                queue.offer(number*5);
                queue.offer(number*7);
            }
        }
        return number;
    }


    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    // O(K) time
    public long kthPrimeNumber2(int k) {
        // write your code here
        long res[] = new long[k+1];
        res[0] = 1;
        int i1 = 0, i2 = 0, i3=0;
        for (int i = 1; i <= k; i++){
            long temp1 = res[i1] * 3;
            long temp2 = res[i2] * 5;
            long temp3 = res[i3] * 7;
            long next = Math.min(Math.min(temp1,temp2),temp3);
            if (next == temp1) i1++;
            if (next == temp2) i2++;
            if (next == temp3) i3++;
            res[i] = next;
        }
        return res[k];
    }
}
