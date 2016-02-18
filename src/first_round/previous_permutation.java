package src.first_round;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by stameying on 1/3/16.
 */
public class previous_permutation {

    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        // write your code
        int k = nums.size()-1;
        // find first digit that is smaller than previous digit
        while ( k > 0 && nums.get(k) >= nums.get(k-1)) k--;
        if (k == 0){
            // return maximum number
            Collections.sort(nums,new Comparator<Integer>(){
                public int compare(Integer i1, Integer i2){
                    return -1*(Integer.compare(i1,i2));
                }
            });
            return new ArrayList<Integer>(nums);
        }
        int q = nums.size()-1;
        // find the largest digit after k-1 but is smaller than value[k-1]
        while (q >= k && nums.get(q) >= nums.get(k-1)) q--;
        swap(nums,k-1,q);
        // sort the part after k-1 to its largest order
        ArrayList<Integer> tempArr = new ArrayList<Integer>();
        for (int i = k; i < nums.size(); i++){
            tempArr.add(nums.get(i));
        }
        Collections.sort(tempArr,new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return -1*(Integer.compare(i1,i2));
            }
        });
        for (int i = k; i < nums.size(); i++){
            nums.set(i,tempArr.get(i-k));
        }
        return new ArrayList<Integer>(nums);
    }

    public void swap(ArrayList<Integer> nums, int left, int right){
        int temp = nums.get(left);
        nums.set(left,nums.get(right));
        nums.set(right,temp);
    }

    public static void main(String[] args) {
        previous_permutation test = new previous_permutation();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(2);
        nums.add(3);
        ArrayList<Integer> res = test.previousPermuation(nums);
        Integer[] arr = res.toArray(new Integer[res.size()]);
        System.out.println(Arrays.toString(arr));
    }
}
