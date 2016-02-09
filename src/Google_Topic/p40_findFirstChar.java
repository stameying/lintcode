package Google_Topic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by stameying on 2/8/16.
 */
public class p40_findFirstChar {

    public static int firstChar(String a, String b){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < b.length(); i++){
            if (!set.contains(b.charAt(i))) set.add(b.charAt(i));
            if (set.size() == 26) break;
        }
        for (int i = 0; i < a.length(); i++){
        	if (set.contains(a.charAt(i))) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstChar("abc","cb"));
    }
}
