package leetcode.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/13/16.
 */
public class encode_decode_strings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str: strs){
            builder.append(str.length());
            builder.append("#");
            builder.append(str);
        }
        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int cur = 0;
        while (cur < s.length()){
            int index = s.indexOf('#',cur);
            int size = Integer.parseInt(s.substring(cur,index));
            res.add(s.substring(index+1,index+size+1));
            cur = index+size+1;
        }
        return res;
    }
}
