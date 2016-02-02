package EPI.heap;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * Created by stameying on 2/1/16.
 */
public class stackUsingHeap {

    private static class ValuesWithRank{
        public Integer timestamp;
        public Integer value;

        public ValuesWithRank(Integer timestamp, Integer value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private static class Compare implements Comparator<ValuesWithRank>{
        @Override
        public int compare(ValuesWithRank o1, ValuesWithRank o2){
            return Integer.compare(o2.timestamp,o1.timestamp);
        }

        public static final Compare COMPARE_VALUEWITHRANK = new Compare();
    }

    public static class Stack{
        private int timestamp = 0;
        private PriorityQueue<ValuesWithRank> maxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, Compare.COMPARE_VALUEWITHRANK);

        public void push(Integer x){
            ValuesWithRank entry = new ValuesWithRank(timestamp++,x);
            maxHeap.add(entry);
        }

        public Integer pop() throws NoSuchElementException{
            return maxHeap.remove().value;
        }

        public Integer peek(){
            return maxHeap.peek().value;
        }
    }
}
