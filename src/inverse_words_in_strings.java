import java.util.ArrayList;

/**
 * Created by stameying on 12/14/15.
 */
public class inverse_words_in_strings {
    public String reverseWords(String s) {
        // write your code
        ArrayList<String> res = new ArrayList<String>();

        // remove leading space
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i > 0){
            s = s.substring(i);
        }
        // remove tailing space
        i = s.length()-1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        if (i < s.length()-1){
            s = s.substring(0,i+1);
        }

        // flag == true means there is leading space
        boolean flag = false;
        String word = "";
        for ( i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' '){
                word += s.charAt(i);
                if (flag) flag = false;
            }else{ // space
                if (flag) continue;
                else{
                    res.add(word);
                    word = "";
                    flag = true;
                }
            }
        }
        if (word.length() > 0){
            res.add(word);
        }
        String resStr = "";
        for (int index = res.size()-1; index>=0; index--){
            resStr += res.get(index);
            if (index != 0){
                resStr += " ";
            }
        }
        return resStr;
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        inverse_words_in_strings test = new inverse_words_in_strings();
        System.out.println(test.reverseWords(s));
    }
}
