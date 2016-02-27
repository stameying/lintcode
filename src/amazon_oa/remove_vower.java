package src.amazon_oa;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by stameying on 2/26/16.
 */
public class remove_vower {

    public static String removevower(String str1, String str2){
        Set<Character> vowerset = new HashSet<>();
        for (int i = 0; i < str2.length(); i++) vowerset.add(str2.charAt(i));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str1.length(); i++){
            if (!vowerset.contains(str1.charAt(i))) builder.append(str1.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str2 = "aeiouAEIOU";
        String str1 = "hello there my name is xiaoran";
        System.out.println(removevower(str1,str2));
    }
}
