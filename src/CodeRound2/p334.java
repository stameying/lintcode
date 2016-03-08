package src.CodeRound2;

/**
 * Created by stameying on 3/7/16.
 */
public class p334 {

    public boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num: nums){
            if (num <= firstMin) firstMin = num;
            else if (num <= secondMin) secondMin = num;
            else return true;
        }
        return false;
    }


}
