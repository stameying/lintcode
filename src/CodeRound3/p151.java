package src.CodeRound3;

import java.util.Arrays;

/**
 * Created by stameying on 3/22/16.
 */
public class p151 {

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        int wordCount = 0;
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            if (word.length() > 0){
//                System.out.println("word="+word+ ",word len="+word.length());
                if (wordCount != 0) builder.insert(0,"*");
                builder.insert(0,word);
                wordCount++;
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        String str = "  a ";
        String[] words = str.split(" ");
        System.out.println(reverseWords(str));
    }
}
