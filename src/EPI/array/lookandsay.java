package EPI.array;

/**
 * Created by stameying on 1/29/16.
 */
public class lookandsay {
    public static String lookandsay(int n){
        String s = "1";
        for (int i = 1; i < n; i++){
            s = nextNumber(s);
        }
        return s;
    }

    public static String nextNumber(String s){
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
                i++;
                count++;
            }
            ret.append(count);
            ret.append(s.charAt(i));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(lookandsay(3));
    }
}
