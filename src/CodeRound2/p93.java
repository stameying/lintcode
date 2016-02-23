package src.CodeRound2;

/**
 * Created by stameying on 2/22/16.
 */
public class p93 {

    public static boolean isValidNumber(String s){
        if (s.length() != 1 && s.charAt(0) == '0') return false;
        if (s.length() <= 2) return true;
        else{
            if (s.charAt(0) > '2') return false;
            else if (s.charAt(0) == '2'){
                if (s.charAt(1) > '5') return false;
                else{
                    if (s.charAt(1) == '5' && s.charAt(2) > '5') return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
//        System.out.println(isValidNumber("216"));
        System.out.println(Integer.parseInt("010"));
    }
}
