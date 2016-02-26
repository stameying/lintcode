package src.amazon_oa;

/**
 * Created by stameying on 2/25/16.
 */
public class p10_evenodd_pattern {


    /**
     * print(4) = 0 2 4 6
     *
     * print(5) = 1 3 5 7 9
     *
     * */

    public static void print4(int num) {
        int i, print = 0;
        if (num % 2 == 0) {
            print = 0;
            for (i = 0; i < num; i++) {
                System.out.print(print + " ");
                print += 2;
            }
        } else {
            print = 1;
            for (i = 0; i < num; i++) {
                System.out.print(print + " ");
                print += 2;
            }
        }
    }

    public static void main(String[] args) {
        print4(5);
    }
}
