package EPI.String;

/**
 * Created by stameying on 1/29/16.
 */
public class baseConvert {

    /**
     * Convert a string represented number from base b1 to base b2
     * */
    public static String baseConver(String s, int b1, int b2){
        boolean isNegative = s.startsWith("-");

        // convert s into decimal based value
        int x = 0;
        for (int i = isNegative?1:0; i < s.length(); i++){
            x *= b1;
            x += Character.isDigit(s.charAt(i))?s.charAt(i)-'0':s.charAt(i)-'A'+10;
        }
        System.out.println("10 based = " + x);
        // convert into b2 based
        StringBuilder builder = new StringBuilder();
        do{
            int mod = x%b2;
            System.out.println("mod="+mod);
            builder.append((char)(mod >= 10?('A'+mod-10):'0'+mod));
        }while (x != 0);

        if (!isNegative) return builder.reverse().toString();
        else return builder.append('-').reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(baseConver("615",7,13));
    }
}
