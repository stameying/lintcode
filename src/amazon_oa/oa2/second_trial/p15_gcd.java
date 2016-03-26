package src.amazon_oa.oa2.second_trial;

/**
 * Created by stameying on 2/28/16.
 */
public class p15_gcd {

    public static int gcd(int[] array){
        if (array == null || array.length <= 1) return 0;
        int gcd = array[0];
        for (int i = 1; i < array.length; i++){
            gcd = findGCD(array[i],gcd);
        }
        return gcd;
    }

    public static int findGCD(int a, int b){
        if (b == 0) return a;
        return findGCD(b,a%b);
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {123456, 7890, 12, 24, 60};
//        System.out.println(gcd(nums));
//        System.out.println(7%4);
//        System.out.println(2%8);

//        int gcd = findGCD(489,333);
////        System.out.println(gcd);
//        if (gcd != 1){
//            int fenmu = 489/gcd;
//            int fenzi = 333/gcd;
//            System.out.println(fenmu+"/"+fenzi);
//        }


        System.out.println(findGCD(8,0));
    }
}
