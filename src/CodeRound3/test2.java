package src.CodeRound3;

/**
 * Created by stameying on 3/19/16.
 */
public class test2 {


    public static int superPower(int num){
//        System.out.println("num="+num);
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                int temp = helper(num/i);
                if (temp != 0){
                    if (temp == i) return 1;
                }
            }
        }
//        int res = helper(num);
//        if (res > 0) return res;
        return 0;
    }

    public static int helper(int num){
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                int temp = helper(num/i);
                if (temp != 0){
                    if (temp == i) return i;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++){
            if (superPower(i) != 0){
                System.out.println("num="+i);
            }
        }
    }
}
