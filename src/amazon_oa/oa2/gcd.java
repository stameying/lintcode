package src.amazon_oa.oa2;

/**
 * Created by stameying on 2/27/16.
 */
public class gcd {


    public static int GCD_arrays(int[] nums){
        if (nums == null || nums.length == 1) return 0;
        int gcd = nums[0];
        for (int i = 1; i < nums.length; i++){
            gcd = gcd(gcd,nums[i]);
        }
        return gcd;
    }

    private static int gcd(int num1, int num2) {
        if (num1 == 0 || num2 == 0)	return 0;
        while (num1 != 0 && num2 != 0) {
            if (num2 > num1) {
                num1 ^= num2;
                num2 ^= num1;
                num1 ^= num2;
            }
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1 + num2;
    }

    public static int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b); }


    public static void main(String[] args) {
        int[] nums = new int[] {123456, 7890, 12, 24, 60};
//        System.out.println(GCD_arrays(nums));
        System.out.println(7%4);
        System.out.println(2%8);
    }
}
