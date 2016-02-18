package Google_Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/17/16.
 */
public class p171_generateString {

    /**
     * Given a String contains only '0','1', and '?'. '?' can represent 0 or 1.
     * Find all the possible combinations of characters by this String
     * */

    public static List<String> generateCombination(String str){
        List<String> res = new ArrayList<>();
        char[] strChar = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        helper(0,strChar,builder,res);
        return res;
    }

    public static void helper(int pos, char[] strChar, StringBuilder builder, List<String> res){
        if (pos == strChar.length){
            res.add(builder.toString());
            return;
        }
//        System.out.println(strChar[pos]);
        if (strChar[pos] != '?'){
            builder.append(strChar[pos]);
            helper(pos+1,strChar,builder,res);
            builder.deleteCharAt(builder.length()-1);
        }
        else{
            builder.append('0');
            helper(pos+1,strChar,builder,res);
            builder.deleteCharAt(builder.length()-1);
            builder.append('1');
            helper(pos+1,strChar,builder,res);
            builder.deleteCharAt(builder.length()-1);
//            StringBuilder nextBuilder = new StringBuilder(builder.toString());
//            nextBuilder.append('0');
//            helper(pos+1,strChar,nextBuilder,res);
//            nextBuilder.deleteCharAt(nextBuilder.length()-1);

//            nextBuilder.append('1');
//            helper(pos+1,strChar,nextBuilder,res);
//            nextBuilder.deleteCharAt(nextBuilder.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateCombination("12?1"));
    }

}
