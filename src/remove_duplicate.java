/**
 * Created by stameying on 12/14/15.
 */
public class remove_duplicate {
    public int removeDuplicates(int[] nums) {
        // write your code here
        int prev = -1;
        for (int i = 0; i < nums.length; i++){
            if (prev == -1 || nums[prev] != nums[i]){
                nums[prev+1] = nums[i];
                prev++;
            }
        }
        return prev+1;
    }

    public int removeDuplicates2(int[] nums) {
        // write your code here
        int prev = -1;
        int count = 1;
        for (int i = 0; i < nums.length; i++){
            if (prev == -1 || nums[prev] != nums[i]){
                nums[prev+1] = nums[i];
                prev++;
                count = 1;
            }else if (nums[prev] == nums[i] && count == 1){
                nums[prev+1] = nums[i];
                prev++;
                count ++;
            }
        }
        return prev+1;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,4,5,5,6};
        remove_duplicate test = new remove_duplicate();
        System.out.println(test.removeDuplicates2(nums));
    }
}
