package EPI.heap;

import java.io.InputStream;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by stameying on 2/1/16.
 */
public class medianOfinputstream {

    public static void onlineMedian(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()){
            int x = s.nextInt();
            if (x == -1) System.exit(0);
            if (minHeap.isEmpty()){
                minHeap.add(x);
            }else{
                if (x >= minHeap.peek()){
                    minHeap.add(x);
                }else{
                    maxHeap.add(x);
                }
            }
            if (minHeap.size() > maxHeap.size()+1){
                maxHeap.add(minHeap.poll());
            }else if (maxHeap.size() > minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }

            System.out.println((minHeap.size()==maxHeap.size())?(double)(0.5*(minHeap.peek()+maxHeap.peek())):(double)minHeap.peek());
        }
    }

    public static void main(String[] args) {
        onlineMedian();
    }
}
