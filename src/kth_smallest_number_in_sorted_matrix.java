import java.util.Arrays;

/**
 * Created by stameying on 12/23/15.
 */
public class kth_smallest_number_in_sorted_matrix {

    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if ( k <= 0 || k > matrix.length * matrix[0].length) return -1;
        headNode[] A = new headNode[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++){
            A[j] = new headNode(matrix[0][j],0,j);
        }
        buildHeap(A,A.length);
        headNode hr = null;
        for (int i = 0; i < k-1; i++){
            hr = A[0];
            int nextVal = hr.row < matrix.length-1? matrix[hr.row+1][hr.column] : Integer.MAX_VALUE;
            int[] intArr = new int[A.length];
            for (int temp = 0; temp < A.length; temp++){
                intArr[temp] = A[temp].value;
            }
            System.out.println("k = " + i + ": " + Arrays.toString(intArr));
            A[0].value = nextVal;
            A[0].row = A[0].row+1;
            minHeapify(A,0,A.length);
        }
        return A[0].value;
    }

    public void buildHeap(headNode[] A, int n){
        int i = (n-1)/2;
        while ( i >= 0){
            minHeapify(A, i, n);
            i--;
        }
    }

    public void minHeapify(headNode[] A, int cur, int n){
        int left = cur * 2 + 1;
        int right = cur * 2 + 2;
        int smallestIndex = cur;
        if (left < n && A[left].value < A[smallestIndex].value){
            smallestIndex = left;
        }
        if (right < n && A[right].value < A[smallestIndex].value){
            smallestIndex = right;
        }
        if (smallestIndex != cur){
            swap(A,cur,smallestIndex);
            minHeapify(A,smallestIndex,n);
        }
    }

    public void swap(headNode[] A, int left, int right) {
        headNode temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,5,7},
                {3,7,8},
                {4,8,9}
        };
        kth_smallest_number_in_sorted_matrix test = new kth_smallest_number_in_sorted_matrix();
        System.out.println(test.kthSmallest(matrix, 4));

    }
}

class headNode{

    int value;
    int row;
    int column;
    public headNode(int value, int row, int column){
        this.value = value;
        this.row = row;
        this.column = column;
    }


}
