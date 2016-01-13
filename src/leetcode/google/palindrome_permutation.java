package leetcode.google;

import java.util.HashMap;

/**
 * Created by stameying on 1/12/16.
 */
public class palindrome_permutation {
    public boolean canPermutePalindrome(String s) {
        boolean evenLen = (s.length()%2 == 0);
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                map.remove(ch);
            }else{
                map.put(ch,1);
            }
        }
        return evenLen?map.size()==0:map.size()==1;
    }
}
