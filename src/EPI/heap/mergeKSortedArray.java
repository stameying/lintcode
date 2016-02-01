package EPI.heap;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by stameying on 2/1/16.
 */
public class mergeKSortedArray {

    private static class ArrayEntry{
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    public static List<Integer> mergeKSortedArray(List<List<Integer>> sortedArray){
        int minHeapSize = sortedArray.size();
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(minHeapSize, new Comparator<ArrayEntry>(){
            @Override
            public int compare(ArrayEntry a1, ArrayEntry a2){
                return Integer.compare(a1.value,a2.value);
            }
        });
        List<Integer> head = new ArrayList<>();

        // put each sotredArray's first element into minHeap
        for (int i = 0; i < sortedArray.size(); i++){
            if (sortedArray.get(i).size() > 0){
                minHeap.offer(new ArrayEntry(sortedArray.get(i).get(0),i));
                head.add(1);
            }else{
                head.add(0);
            }
        }

        List<Integer> res = new ArrayList<>();
        ArrayEntry headEntry;
        while ((headEntry = minHeap.poll()) != null){
            res.add(headEntry.value);
            List<Integer> updateArray = sortedArray.get(headEntry.arrayId);
            int updatedArrayHead = head.get(headEntry.arrayId);
            if (updatedArrayHead < updateArray.size()){
                minHeap.offer(new ArrayEntry(updateArray.get(updatedArrayHead), headEntry.arrayId));
                head.set(headEntry.arrayId, ++updatedArrayHead);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(3,5,7));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(0,6));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(0,6,28));
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        System.out.println(mergeKSortedArray(lists));
    }
}
