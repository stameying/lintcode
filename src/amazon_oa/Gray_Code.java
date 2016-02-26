package src.amazon_oa;

/**
 * Created by stameying on 2/25/16.
 */
public class Gray_Code {

    public static int gray_code(byte term1, byte term2){
        byte res = (byte)(term1^term2);
        if (res == 0) return 0; // same code
        else return (res&(res-1))==0?1:0;  // res &= (res-1) delete the last 1 bit from res
    }

    public static int gray_code2(byte term1, byte term2){
        byte res = (byte)(term1^term2);
        int total = 0;
        while (res != 0){
            res = (byte)(res&(res-1));
            total++;
        }
        if (total == 1) return 1;
        else return 0;
    }


    public static void main(String[] args) {
        byte term1 = 101;
        byte term2 = -27;
        System.out.println(gray_code(term1,term2));

//        boolean hitMax = false;
//        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++){
//            System.out.println(i);
//        }

        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++){
            for (int j = Byte.MIN_VALUE; j <= Byte.MAX_VALUE; j++){
                int res1 = gray_code((byte)i,(byte)j);
                int res2 = gray_code2((byte)i,(byte)j);
//                System.out.println("res1="+res1 + ",res2="+res2);
                if (res1 != res2){
                    System.out.println("i = " + Byte.toString((byte)i) + " j = " + Byte.toString((byte)j));
                }
            }
        }


//        System.out.println(gray_code(term1,term2));
    }
}
