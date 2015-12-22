import java.util.Arrays;

/**
 * Created by stameying on 12/20/15.
 */
public class find_missing_number {

    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing1(int[] nums) {
        // write your code here
        int index = 0;
        while (index < nums.length){
            if (nums[index] != index){
                if (nums[index] < nums.length){
                    int temp = nums[nums[index]];
                    nums[nums[index]] = nums[index];
                    nums[index] = temp;
                }else{
                    index++;
                }
            }else{
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i) return i;
        }
        return nums.length;
    }


    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            res ^= (i+1)^nums[i];
        }
        return res;

    }

}
