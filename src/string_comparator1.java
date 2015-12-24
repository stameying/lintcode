import java.util.Comparator;

/**
 * Created by stameying on 12/23/15.
 */
public class string_comparator1 implements Comparator<String> {
    /* compare two string by comparing each character,
    *  the larger goes first
    * */
    public int compare(String str1, String str2) {
        int res = 0;
        int pos1 = 0, pos2 = 0;
        char repeatChar = ' ';
        int repeatFlag = 0;
        while (pos1 < str1.length() || pos2 < str2.length()) {
            if (pos1 == str1.length() && repeatFlag == 0) {
                repeatChar = str1.charAt(0);
                repeatFlag = 1;
            }
            if (pos2 == str2.length() && repeatFlag == 0) {
                repeatChar = str2.charAt(0);
                repeatFlag = 2;
            }
            int digit1 = 0;
            int digit2 = 0;
            if (repeatFlag == 0) {
                digit1 = str1.charAt(pos1) - '0';
                digit2 = str2.charAt(pos2) - '0';
            } else if (repeatFlag == 1) {
                digit1 = repeatChar - '0';
                digit2 = str2.charAt(pos2) - '0';
            } else {
                digit1 = str1.charAt(pos1) - '0';
                digit2 = repeatChar - '0';
            }
            if (digit1 > digit2) return 1;
            else if (digit1 < digit2) return -1;
            else {
                pos1++;
                pos2++;
            }
        }
        if (str1.length() < str2.length()){
            for (int i = 0 ; i < str2.length()-1; i++){
                if ( (str2.charAt(i+1)-'0') > (str2.charAt(i)-'0') ) return 1;
                else if ((str2.charAt(i+1)-'0') < (str2.charAt(i)-'0')) return -1;
            }
        }
        else if (str1.length() > str2.length()){
            for (int i = 0 ; i < str1.length()-1; i++){
                if ( (str1.charAt(i+1)-'0') > (str1.charAt(i)-'0') ) return -1;
                else if ((str1.charAt(i+1)-'0') < (str1.charAt(i)-'0')) return 1;
            }
        }
        return 1;
    }
}
