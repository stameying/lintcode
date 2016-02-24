package src.CodeRound2;

/**
 * Created by stameying on 2/23/16.
 */
public class p135 {

    public static int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        dp[0] = 0;
        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] < ratings[i-1]){
                dp[i] = dp[i-1]+1;
            }else{
                dp[i] = 0;
            }
        }

        int num = 0;
        int index = 0;
        while (index < ratings.length){
            int lookAheadIdx = index;
            while (lookAheadIdx+1 < ratings.length && dp[lookAheadIdx] <= dp[lookAheadIdx+1]) lookAheadIdx++;
            int candy = 1;
            while (index <= lookAheadIdx){
                System.out.println(num);
                num += (candy++);
                index++;
            }
            index = lookAheadIdx+1;
//            System.out.println(index);
        }
        return num;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{6,1,4,3,2,6,4,2};
        System.out.println(candy(nums));
    }
}
