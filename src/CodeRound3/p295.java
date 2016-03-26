package src.CodeRound3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stameying on 3/25/16.
 */
public class p295 {

    /*
    最大堆最小堆
    左边是 最大堆，保持小的一半部分
    右边是 最小堆，保持大的一半部分


    左边的size == 右边的size
    或者 左边的size == 右边的size+1

    */

    protected double median;
    protected int size;
    protected PriorityQueue<Integer> maxHeap, minHeap;

    public p295(){
        maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return Integer.compare(i2,i1);
            }
        });
        minHeap = new PriorityQueue<>();
        this.median = 0;
        this.size = 0;
    }


    // Adds a number into the data structure.
    public void addNum(int num) {
        this.size++;
        if (maxHeap.isEmpty() && minHeap.isEmpty()){
            maxHeap.offer(num);
            median = (double)num;
            return;
        }
        if (num <= median){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        while (maxHeap.size() != minHeap.size() && maxHeap.size() != (minHeap.size()+1)){
            if (maxHeap.size() > minHeap.size()){
                minHeap.offer(maxHeap.poll());
            }else{
                maxHeap.offer(minHeap.poll());
            }
        }

        if (this.size%2==0){
            // even size
            median = (double)(maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            median =  (double)maxHeap.peek();
        }

        System.out.println(maxHeap + " || " + minHeap + " || " + median);
        return;
    }

    // Returns the median of current data stream
    public double findMedian() {
        return this.median;
    }

    public static void main(String[] args) {
        p295 test = new p295();

        test.addNum(1);
        test.addNum(2);

    }
}
