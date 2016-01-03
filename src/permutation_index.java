import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by stameying on 12/14/15.
 */
public class permutation_index {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        int[] nums = Arrays.copyOf(A,A.length);
        HashSet<Integer> checker = new HashSet<Integer>();
        Arrays.sort(nums);
        long index = 0;
        for (int i = 0; i < A.length; i++){
            index += getLess(A[i],checker,nums) * getIndexFactor(A.length-i);
            checker.add(A[i]);
        }
        return index;
    }

    public int getLess(int num, HashSet<Integer> checker, int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (num > nums[i]){
                if (!checker.contains(nums[i])) count++;
            }else{
                System.out.println("less than " + num + "=" + count);
                return count;
            }
        }
        System.out.println("less than " + num + "=" + count);
        return count;
    }

    public long getIndexFactor(int num){
        if (num == 0) return 0;
        long res = 1;
        for (int i = num-1; i >= 1; i--){
            res *= i;
        }
        System.out.println("num index = " + res);
        return res;
    }

    /*
    * Practice 2
    * */
    public long permutationIndex2(int[] A) {
        // Write your code here
        int[] nums = Arrays.copyOf(A,A.length);
        Arrays.sort(nums);
        Set<Integer> usedSet = new HashSet<Integer>();
        long index = 0;
        for (int i = 0; i < A.length; i++){
            index += getLessCount(A[i],usedSet,nums) * getIndexFactor2(A.length-i);
            usedSet.add(A[i]);
        }
        return index;
    }

    public int getLessCount(int num, Set<Integer> set, int[] nums){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] < num){
                if (!set.contains(nums[i])) count++;
            }else{
                return count;
            }
        }
        return count;
    }

    public long getIndexFactor2(int index){
        if (index == 0) return 0;
        long res = 1;
        for (int i = index-1; i >= 1; i--){
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {2,1,4};
        permutation_index test = new permutation_index();
        test.permutationIndex2(input);
    }
}
