package leetcode.google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stameying on 1/23/16.
 */
public class lengthOfLongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        if (s.length() <= 2) return s.length();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int maxLen = 0, curLen = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (map.size() < 2 || map.containsKey(ch)){
                map.put(ch,i);
                curLen++;
                maxLen = Math.max(curLen,maxLen);
            }else{
                char prev = s.charAt(i-1);
                int newStart = 0;
                for (Map.Entry<Character,Integer> entry: map.entrySet()){
                    if (entry.getKey() != prev){
                        newStart = entry.getValue()+1;
                        map.remove(entry.getKey());
                        break;
                    }
                }
                curLen = i-newStart+1;
                map.put(ch,i);
                maxLen = Math.max(curLen,maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstringTwoDistinct test = new lengthOfLongestSubstringTwoDistinct();
        System.out.println(test.lengthOfLongestSubstringTwoDistinct("ecebaabc"));
    }
}
