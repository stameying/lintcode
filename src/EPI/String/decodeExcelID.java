package EPI.String;

/**
 * Created by stameying on 1/29/16.
 */
public class decodeExcelID {

    public static int decode(String str){
        int base = 1, res = 0;
        for (int i = str.length()-1; i >= 0; i--){
            char ch = str.charAt(i);
            res += (base*(ch-'A'+1));
            base *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decode("AA"));
    }
}
