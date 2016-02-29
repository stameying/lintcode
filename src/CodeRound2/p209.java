package src.CodeRound2;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by stameying on 2/28/16.
 */
public class p209 {

    public static int res = 0;
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, windowSum = 0, minLen = nums.length;
        while (right < nums.length){
            windowSum += nums[right];
            if (windowSum < s){
                right++;
            }else{
                while (left <= right && windowSum >= s){
                    System.out.println("1");
                    int curLen = right-left+1;
                    minLen = Math.min(curLen,minLen);
                    windowSum -= nums[left];
                    left++;
                }
                right++;
            }

        }
        return minLen == nums.length? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen(15,nums));
    }
}
