package leetcode.google;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by stameying on 1/22/16.
 */
public class find_median_from_data_stream {

    Queue<Integer> max;
    Queue<Integer> min;
    /*
    * left keeps track of the
    */
    public find_median_from_data_stream(){
        max = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return Integer.compare(i2,i1);
            }
        }); // max heap
        min = new PriorityQueue<Integer>();// min heap
    }
    // Adds a number into the data structure.
    // 最大堆的size == 最小堆的size or 最大堆的size == 最小堆的size+1
    public void addNum(int num) {
        //最大堆是空，或者新数比最大堆堆顶的数小,加入最大堆
        if (max.size()==0 || num <= max.peek()){
            if (max.size() > min.size()){
                min.offer(max.poll());
            }
            max.offer(num);
            //最小堆是空，或者新数比最小堆堆顶的数大，加入最小堆
        }else if (min.size() == 0 || num >= min.peek()){
            if (max.size() == min.size()){
                max.offer(min.poll());
            }
            min.offer(num);
            //新数在两个数之间
        }else{
            if (max.size() == min.size()){
                max.offer(num);
            }else{
                min.offer(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int totalLen = max.size()+min.size();
        if ((totalLen&1) == 0){ // even
            return (max.peek()+min.peek())/2.0;
        }else{//odd
            return (double)max.peek();
        }
    }

    public void testDisplay(){
        System.out.println("max size="+max.size()+"  min size="+min.size());
    }

    public static void main(String[] args) {
        find_median_from_data_stream test = new find_median_from_data_stream();
        test.addNum(5);
        test.testDisplay();
        test.addNum(5);
        test.testDisplay();
        test.addNum(7);
        test.testDisplay();
        test.addNum(1);
        test.testDisplay();
        test.addNum(3);
        test.testDisplay();
    }
}
