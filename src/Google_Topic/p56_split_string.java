package Google_Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 2/9/16.
 */
public class p56_split_string {

    public static List<String> splitString(String str){
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
        	char ch = str.charAt(i);
        	if (ch == '\"'){
        		int lookAheadIdx = i+1;
        		while (lookAheadIdx < str.length() && str.charAt(lookAheadIdx) != '\"') lookAheadIdx++;
        		res.add(str.substring(i+1,lookAheadIdx));
        		i = lookAheadIdx;
        	}else if (ch == ' '){
        		while ( i+1 < str.length() && str.charAt(i+1) == ' ') i++;
        		if (builder.length() != 0){
        			res.add(builder.toString());
        			builder.setLength(0);
        		}
        	}else{
        		builder.append(ch);
        	}
        }
        if (builder.length() != 0) res.add(builder.toString());
        return res;
    }

    public static void main(String[] args) {
        String s = "Location \"Welcome to india\" Bangalore Channai \"IT city\" Mysore";
        System.out.println(splitString(s));
    }
}
