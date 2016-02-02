package EPI.Binary_Search_Tree;

import java.util.*;

/**
 * Created by stameying on 2/1/16.
 */
public class closetEntries {

    private static class ArrayEntry implements Comparable<ArrayEntry>{
        public Integer value;
        public Integer index;

        public ArrayEntry(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayEntry o){
            int result = Integer.compare(this.value,o.value);
            if (result == 0) result = Integer.compare(this.index,o.index);
            return result;
        }

        @Override
        public boolean equals(Object obj){
            if (obj == null || !(obj instanceof ArrayEntry)) return false;
            if (this == obj) return true;
            ArrayEntry that = (ArrayEntry)obj;
            return this.value == that.value && this.index == that.index;
        }
    }

    public static int findMinDistance(List<List<Integer>> sortedArrays){
        List<Integer> heads = new ArrayList<>(sortedArrays.size());
        for (List<Integer> arr: sortedArrays) heads.add(0);
        int res = Integer.MAX_VALUE;
        NavigableSet<ArrayEntry> currentHeads = new TreeSet<>();
        for (int i = 0; i < sortedArrays.size(); i++){
            currentHeads.add(new ArrayEntry(sortedArrays.get(i).get(heads.get(i)),i));
        }
        while (true){
            res = Math.min(res, currentHeads.last().value-currentHeads.first().value);
            int nextIndex = currentHeads.first().index;
            heads.set(nextIndex,heads.get(nextIndex)+1);
            if (heads.get(nextIndex) >= sortedArrays.get(nextIndex).size()){
                System.out.println(currentHeads.first().value + "->" + currentHeads.last().value);
                return res;
            }
            currentHeads.pollFirst();
            currentHeads.add(new ArrayEntry(sortedArrays.get(nextIndex).get(heads.get(nextIndex)),nextIndex));
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(5,10,15));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3,6,9,12,15));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(8,16,24));
        List<List<Integer>> lists = new ArrayList<>(Arrays.asList(list1,list2,list3));
        System.out.println(findMinDistance(lists));

    }
}
