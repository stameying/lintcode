package Google_Topic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stameying on 2/10/16.
 */
public class p72_largest_substring_with_at_most_m_distinct_characters {


    public static int longest_substring(String str, int k){
        Map<Character,Integer> map = new HashMap<>();
        if (str == null) return 0;
        if (str.length() <= k) return str.length();
        int maxLen = 0, windowLeft = -1;
        for (int i = 0; i < str.length(); i++){
        	char ch = str.charAt(i);
        	if (map.size() == k && !map.containsKey(ch)){
        		int localLen = i-(windowLeft+1);
        		maxLen = Math.max(localLen,maxLen);
        		int leftMost = i;
        		char candidateChar = 'a';
        		for (Map.Entry<Character,Integer> entry: map.entrySet()){
        			if (entry.getValue() < leftMost){
        				leftMost = entry.getValue();
        				candidateChar = entry.getKey();
        			}
        		}
        		windowLeft = leftMost;
        		map.remove(candidateChar);
        	}
        	map.put(ch,i);
        }
        maxLen = Math.max(maxLen, str.length()-(windowLeft+1));
        return maxLen;
    }

    public static void main(String[] args) {
        
    }

}
