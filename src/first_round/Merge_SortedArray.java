package src.first_round;

/**
 * Created by stameying on 12/13/15.
 */
public class Merge_SortedArray {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int curA = m-1, curB = n-1;

        while (curA >= 0 || curB >= 0){
            if (curA >= 0 && curB >= 0){
                if (A[curA] >= B[curB]){
                    A[curA+curB+1] = A[curA--];
                }else{
                    A[curA+curB+1] = B[curB--];
                }
            }
            else if (curA < 0){
                A[curB] = B[curB--];
            }else{ // curB < 0
                break;
            }
        }
    }
}
