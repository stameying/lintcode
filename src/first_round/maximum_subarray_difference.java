package src.first_round;

/**
 * Created by stameying on 12/28/15.
 */
public class maximum_subarray_difference {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
//        int len = nums.length;
//        int[] leftMax = new int[len+1];
//        int[] leftMin = new int[len+1];
//        int[] rightMax = new int[len+1];
//        int[] rightMin = new int[len+1];
//
//        for (int i = 0; i < len; i++){
//            if (nums[i] >= 0){
//                leftMax[i+1] = leftMax[i]+nums[i];
//                leftMin[i+1] = Math.min(0,leftMin[i]+nums[i]);
//            }else{
//                leftMax[i+1] = Math.max(0,leftMax[i]+nums[i]);
//                leftMin[i+1] = leftMin[i]+nums[i];
//            }
//        }
//
//        for (int i = len-1; i>= 0; i--){
//            if (nums[i] >= 0){
//                rightMax[i] = rightMax[i+1]+nums[i];
//                rightMin[i] = Math.min(0,rightMin[i+1]+nums[i]);
//            }else{
//                rightMax[i] = Math.max(0,rightMax[i+1]+nums[i]);
//                rightMin[i] = rightMin[i+1]+nums[i];
//            }
//        }

        if (nums == null)
            return 0;
        int len = nums.length, currMaxSum = 0, currMinSum = 0;
        int[] leftGlobalMax = new int[len];
        int[] leftGlobalMin = new int[len];
        for (int i = 0; i < len - 1; i++) {
            int localMax = currMaxSum + nums[i];
            int localMin = currMinSum + nums[i];
            if (i == 0) {
                leftGlobalMax[i + 1] = localMax;
                leftGlobalMin[i + 1] = localMin;
            } else {
                leftGlobalMax[i + 1] = Math.max(localMax, leftGlobalMax[i]);
                leftGlobalMin[i + 1] = Math.min(localMin, leftGlobalMin[i]);
            }
            currMaxSum = Math.max(0, localMax);
            currMinSum = Math.min(0, localMin);
        }
        currMaxSum = 0;
        currMinSum = 0;
        int maxDiff = 0;
        for (int i = len - 1; i > 0; i--) {
            int localMax = currMaxSum + nums[i];
            int localMin = currMinSum + nums[i];
            int localMaxDiff = Math.max(leftGlobalMax[i] - localMin, localMax - leftGlobalMin[i]);
            maxDiff = Math.max(maxDiff, localMaxDiff);
            currMaxSum = Math.max(0, localMax);
            currMinSum = Math.min(0, localMin);
        }


        displayArr(leftGlobalMax);
        displayArr(leftGlobalMin);

//        int max = 0;
//        for (int i = 1; i <= len; i++){
//            int leftMaxValue = leftMax[i-1];
//            int rightMinValue = rightMin[i];
//            int value1 = Math.abs(leftMaxValue-rightMinValue);
//            int leftMinValue = leftMin[i-1];
//            int rightMaxValue = rightMax[i];
//            int value2 = Math.abs(leftMinValue-rightMaxValue);
//            int curMax = Math.max(value1,value2)+Math.abs(nums[i-1]);
//            if (curMax > max) max = curMax;
//        }
        return maxDiff;
    }

    public void displayArr(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if (i != arr.length-1){
                System.out.print(",");
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] arr = {2,-3,1,4,-3};
        maximum_subarray_difference test = new maximum_subarray_difference();
        System.out.println(test.maxDiffSubArrays(arr));
    }
}
