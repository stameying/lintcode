package Google_Topic;

import java.util.*;

/**
 * Created by stameying on 2/16/16.
 */
public class p148_no_neighbor_char_strings {


    /**
     * AABB -> ABAB
     * AAAB -> -1
     * */
    public static String rerangeString(String str){
        Map<Character,Integer> map = new HashMap<>();
        Set<Character> charSet = new HashSet<>();
        char[] charArr = str.toCharArray();
        for (char ch: charArr){
            if (!map.containsKey(ch)) map.put(ch,1);
            else map.put(ch,map.get(ch)+1);
            if (map.get(ch) > (str.length()+1)/2) return "-1";
            if (!charSet.contains(ch)) charSet.add(ch);
        }

        StringBuilder builder = new StringBuilder();
        while (map.size() > 0){
            Iterator iter = charSet.iterator();
            while (iter.hasNext()){
                char ch = (char)iter.next();
                if (map.containsKey(ch)){
                    builder.append(ch);
                    map.put(ch,map.get(ch)-1);
                    if (map.get(ch) == 0) map.remove(ch);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(rerangeString("AABB"));
    }
}
