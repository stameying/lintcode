import java.util.HashMap;
import java.util.Map;

/**
 * Created by stameying on 12/25/15.
 */
public class Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s.length() == 0 ) return 0;
        else if (s.length() == 1) return 1;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int maxLen = 0, curLen = 0, curStart = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                curLen++;
                if (curLen > maxLen) maxLen = curLen;
            } else {
                int lastPos = map.get(s.charAt(i));
                for (int j = curStart; j <= lastPos; j++) {
                    map.remove(s.charAt(j));
                }
                curStart = lastPos + 1;
                map.put(s.charAt(i), i);
                curLen = i - lastPos;
            }
        }

        for (Map.En)
        return maxLen;
    }
}
