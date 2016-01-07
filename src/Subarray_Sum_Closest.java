import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by stameying on 1/6/16.
 */
public class Subarray_Sum_Closest {

    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */

    /*
    * Memory limit exceeded
    * */
    public static int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;
        int[][] matrix = new int[nums.length][nums.length];
        int closet = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                res[0] = i;
                res[1] = i;
                return res;
            }
            matrix[i][i] = nums[i];
            if (Math.abs(matrix[i][i]) < closet){
                closet = Math.abs(matrix[i][i]);
                res[0] = i;
                res[1] = i;
            }
        }
        for (int j = 0; j < nums.length; j++){
            for (int i = j-1; i >= 0; i--){
                matrix[i][j] = matrix[i][j-1]+nums[j];
                if (Math.abs(matrix[i][j]) < closet){
                    closet = Math.abs(matrix[i][j]);
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public static int[] subarraySumClosest2(int[] nums) {
        // write your code here
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;
        if (nums.length <= 1) return res;
        int[] sumArr = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            sumArr[i] = sum;
        }
        Arrays.sort(sumArr);
        System.out.println(Arrays.toString(sumArr));
        int closet = Integer.MAX_VALUE;
        int left = 0, right = nums.length-1;
        for (int i = 0; i < sumArr.length-1; i++){
            if(Math.abs(sumArr[i+1]-sumArr[i]) < closet){
                closet = Math.abs(sumArr[i+1]-sumArr[i]);
                left = sumArr[i];
                right = sumArr[i+1];
                System.out.println("closet="+closet + ", left="+left+",right="+right);
            }

        }
        boolean findFirst = false;
        System.out.println("left="+left+";right="+right);
        int firstPos = -1, secondPos = -1;
        sum = 0;
        for (int i = 0; i < sumArr.length; i++){
            sum += nums[i];
            if (sum == left || sum == right){
                if (!findFirst){
                    firstPos = i;
                    findFirst = !findFirst;
                }else{
                    secondPos = i;
                    break;
                }
            }
        }
        res[0] = Math.min(firstPos,secondPos)+1;
        res[1] = Math.max(firstPos,secondPos);
        System.out.println(Arrays.toString(res));
        return res;
    }

    public ArrayList<Integer> subarraySumClosest3(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
        long sum = 0;
        long minDiff = (long)(Integer.MAX_VALUE)+1;
        res.add(0);
        res.add(0);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            Map.Entry floorEntry = map.floorEntry(sum);
            Map.Entry ceilingEntry = map.ceilingEntry(sum);
            int curDiff = 0;
            if (floorEntry != null || ceilingEntry != null) {
                if (floorEntry == null || (ceilingEntry != null && Math.abs((long)floorEntry.getKey() - sum) > Math.abs((long)ceilingEntry.getKey() - sum))) {
                    if (Math.abs((long)ceilingEntry.getKey() - sum) < minDiff) {
                        res.set(0, (int)ceilingEntry.getValue() + 1);
                        res.set(1, i);
                    }
                } else { //floor
                    if (Math.abs((long)floorEntry.getKey() - sum) < minDiff) {
                        res.set(0, (int)floorEntry.getValue() + 1);
                        res.set(1, i);
                        minDiff = Math.abs((long)floorEntry.getKey() - sum);
                    }
                }
            }
            map.put(sum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {6,-4,-8,3,1,7};
        int[] res = subarraySumClosest2(nums);

    }
}
