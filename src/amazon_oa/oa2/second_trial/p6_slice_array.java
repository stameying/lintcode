package src.amazon_oa.oa2.second_trial;

/**
 * Created by stameying on 2/27/16.
 */
public class p6_slice_array {

    public static int Solution(int[] A){
        if (A == null || A.length <= 2) return 0;
        int count = 0, preGap = A[1]-A[0], curLen = 2;
        for (int i = 1; i < A.length-1; i++){
            int nextGap = A[i+1]-A[i];
            if (nextGap == preGap){
                curLen++;
                continue;
            }else{
                preGap = nextGap; // important
                if (curLen >= 3){
                    count += getValidCount(curLen-2);
                }
                if (count > 1000000000) return -1;
                curLen = 2;
            }
        }
        // last one
        if (curLen >= 3) count += getValidCount(curLen-2);
        if (count > 1000000000) return -1;
        return count;
    }

    public static int getValidCount(int n){
        return n * (n+1) / 2;
    }

    public static void main(String[] args) {
        int[] array = {-1,1,3,3,3,2,1,0};
        System.out.println(Solution(array));
    }
}
