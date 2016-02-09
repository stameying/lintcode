package Google_Topic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by stameying on 2/7/16.
 */
public class p17_palindrome {

    public static boolean checkPalindrome(String str){
        Set<Character> oddChar = new HashSet<>();
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (!oddChar.contains(ch)) oddChar.add(ch);
            else oddChar.remove(ch);
        }
        return oddChar.size()==1;
    }

    public static boolean checkPalindrome2(String str){
    	HashMap<Character,Integer> map = new HashMap<>();
    	for (int i = 0; i < str.length(); i++){
    		char ch = str.charAt(i);
    		if (!map.containsKey(ch)) map.put(ch,1);
    		else map.put(ch,0); // or delete
    	}
    	int cnt = 0;
    	for (Map.Entry<Character,Integer> entry: map.entrySet()){
    		if (entry.getValue()%2 == 1) cnt++;
    	}
    	return cnt==1;
    }

}
