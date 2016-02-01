package EPI.Search;

import java.util.*;

/**
 * Created by stameying on 1/31/16.
 */


public class quickselect {
    private static class Compare{
        private static class GreaterThan implements Comparator<Integer>{
            public int compare(Integer a, Integer b){
                return Integer.compare(a,b);
            }
        }

        public static final GreaterThan GREATER_THAN = new GreaterThan();

    }

    public static int findKthLargest(List<Integer> A, int k){
        return findKth(A,k,Compare.GREATER_THAN);
    }

    public static int findKth(List<Integer> A, int k, Comparator<Integer> cmp){
        int left = 0, right = A.size()-1;
        Random r = new Random();
        while (left <= right){
            int pivotIdx = r.nextInt(right-left+1)+left;
            int newPivotIdx = partition(left,right,pivotIdx,A,cmp);
            if (newPivotIdx == k-1) return A.get(newPivotIdx);
            else if (newPivotIdx > k-1){
                right = newPivotIdx-1;
            }else{
                left = newPivotIdx+1;
            }
        }
        return -1;
    }

    public static int partition(int left, int right, int pivot, List<Integer> A, Comparator<Integer> cmp){
        int pivotVal = A.get(pivot);
        int newPivotIndex = left;
        Collections.swap(A,pivot,right);
        for (int i = left; i < right; i++){
            if (cmp.compare(A.get(i), pivotVal) < 0){
                Collections.swap(A, i, newPivotIndex++);
            }
        }
        Collections.swap(A,right,newPivotIndex);
        System.out.println(A);
        System.out.println("newPivotIndex="+newPivotIndex);
        return newPivotIndex;
    }


    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(3,4,1,5,2));
        System.out.println(findKthLargest(A,2));
    }
}
