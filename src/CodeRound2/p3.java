package src.CodeRound2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stameying on 2/18/16.
 */
public class p3 {

    /**
     * Longest Substring Without Repeating Characters
     *
     * Given a string, find the length of the longest substring without repeating characters.
     * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
     * For "bbbbb" the longest substring is "b", with the length of 1.
     * */

    /**
     * Solution:
     * 维护一个窗口 和 一个哈希表,
     * 如果当前字符不存在窗口里, 讲当前字符和位置插入哈希表
     * 反之, 比较当前窗口和最大窗口, 如果大于最大窗口, 则更新最大窗口的值.
     * 从哈希表中删除 当前窗口的最左侧到当前重复字符在窗口里出现的位置间出现的字母.
     * 更新当前窗口的左边距
     *
     * */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLen = 0, curStart = -1;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (!map.containsKey(ch)){
                map.put(ch,i);
            }else{
                int curLen = i-curStart-1;
                maxLen = Math.max(maxLen,curLen);
                // ! important to delete chars from left window to duplicate char position
                for (int j = curStart+1; j < map.get(ch); j++){
                    map.remove(s.charAt(j));
                }
                curStart = map.get(ch);
                map.put(ch,i);
            }
        }
        maxLen = Math.max(maxLen,s.length()-curStart-1);
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
