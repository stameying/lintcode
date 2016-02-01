package EPI.heap;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.PriorityQueue;

/**
 * Created by stameying on 2/1/16.
 */
public class sortKSotedArray {

    public static void sortApproximatelySotredData(InputStream sequence, int k) throws ClassNotFoundException, IOException{
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        try{
            ObjectInputStream osin = new ObjectInputStream(sequence);
            for (int i = 0; i < k; i++){
                minHeap.add((Integer)osin.readObject());
            }

            while (true){
                minHeap.add((Integer)osin.readObject());
                Integer smallest = minHeap.remove();
                System.out.println(smallest);
            }
        }catch (EOFException e){}
        while (!minHeap.isEmpty()) System.out.println(minHeap.remove());
    }

    public static void main(String[] args) {

    }

}
