package src.CodeRound2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/29/16.
 */
public class p229 {

    public static List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0, candidate1 = 0, candidate2 = 0;
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (cnt1 == 0){
                candidate1 = num;
                cnt1 = 1;
            }else if (cnt2 == 0){
                candidate2 = num;
                cnt2 = 1;
            }else{
                if (num == candidate1){
                    cnt1++;
                }else if (num == candidate2){
                    cnt2++;
                }else{
                    cnt1--;
                    cnt2--;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        if (candidate1 == candidate2){
            res.add(candidate1);
            return res;
        }else{
            res.add(candidate1);
            res.add(candidate2);
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(majorityElement(nums));
    }
}
