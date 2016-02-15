package Google_Topic;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stameying on 2/13/16.
 */
public class p114_data_stream {

    PriorityQueue<Integer> minHeap, maxHeap;
    public p114_data_stream(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(MaxHeapComparator.comparator);
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (minHeap.size() == 0 && maxHeap.size() == 0){
            minHeap.offer(num);
            return;
        }
        if (num <= findMedian()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        if (minHeap.size() == maxHeap.size()+2){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()){
            return (double)(maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            if (minHeap.size() != 0) return (double)minHeap.peek();
            else return (double)maxHeap.peek();
        }
    }

    private static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2){
            return Integer.compare(i2,i1);
        }

        public static final MaxHeapComparator comparator = new MaxHeapComparator();
    }


    public static void main(String[] args) {
        p114_data_stream test = new p114_data_stream();
        test.addNum(2);
        System.out.println(test.findMedian());
        test.addNum(3);
        System.out.println(test.findMedian());
    }
}
