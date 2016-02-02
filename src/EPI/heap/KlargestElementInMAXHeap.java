package EPI.heap;

import java.util.*;

/**
 * Created by stameying on 2/1/16.
 */
public class KlargestElementInMAXHeap {
    private static class HeapEntry{
        public Integer value;
        public Integer index;

        public HeapEntry(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }
    }

    private static class Compare implements Comparator<HeapEntry> {
        @Override
        public int compare(HeapEntry o1, HeapEntry o2){
            return Integer.compare(o2.value,o1.value);
        }
        public static final Compare COMPARE_HEAP_ENTRIES = new Compare();
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public static List<Integer> kLargestInBinaryHeap(List<Integer> A, int k){
        if (k <= 0) return new ArrayList<>();

        PriorityQueue<HeapEntry> candidateMaxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, Compare.COMPARE_HEAP_ENTRIES);
        candidateMaxHeap.add(new HeapEntry(A.get(0),0));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++){

            Integer candidateIdx = candidateMaxHeap.peek().index;
            res.add(candidateMaxHeap.remove().value);

            Integer leftChildIdx = 2 * candidateIdx + 1;
            if (leftChildIdx < A.size()){
                candidateMaxHeap.add(new HeapEntry(A.get(leftChildIdx),leftChildIdx));
            }
            Integer rightChildIdx = 2 *  candidateIdx + 2;
            if (rightChildIdx < A.size()){
                candidateMaxHeap.add(new HeapEntry(A.get(rightChildIdx),rightChildIdx));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(561,314,401,28,156,359,271,11,3));
        System.out.println(kLargestInBinaryHeap(A,4));
    }
}
