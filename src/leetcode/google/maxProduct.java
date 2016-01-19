package leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by stameying on 1/18/16.
 */
public class maxProduct {


    // tle
    public int maxProduct1(String[] words) {
        int maxLen = 0;
        Map<String,Set<Character>> map = new HashMap<String,Set<Character>>();
        for (String word: words){
            Set<Character> charSet = new HashSet<Character>();
            for (int i = 0; i < word.length(); i++){
                charSet.add(word.charAt(i));
            }
            map.put(word,charSet);
        }
        for (String word1: words){
            for (String word2: words){
                if (!word1.equals(word2)){
                    Set<Character> charSet1 = map.get(word1);
                    Set<Character> charSet2 = map.get(word2);
                    boolean containSameChar = false;
                    if (charSet1.size() < charSet2.size()){
                        for (char ch1: charSet1){
                            if (charSet2.contains(ch1)){
                                containSameChar = true;
                                break;
                            }
                        }
                    }else{
                        for (char ch2: charSet2){
                            if (charSet1.contains(ch2)){
                                containSameChar = true;
                                break;
                            }
                        }
                    }
                    if (!containSameChar){
                        maxLen = Math.max(maxLen, word1.length() * word2.length());
                    }
                }
            }
        }
        return maxLen;
    }

    // bit manipulate
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) return 0;

        // pre-processing
        int[] processWords= new int[words.length];
        for (int i = 0; i < words.length; i++){
            processWords[i] = 0;
            for (int j = 0; j < words[i].length();j++){
                processWords[i] |= 1 << (words[i].charAt(j)-'a');
            }
        }

        int maxLen = 0;
        // get result
        for (int i = 0; i < words.length; i++){
            for (int j = i+1; j < words.length; j++){
                if ((processWords[i] & processWords[j]) == 0){
                    // no common letter
                    maxLen = Math.max(maxLen,words[i].length()*words[j].length());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        maxProduct test = new maxProduct();
        System.out.println(test.maxProduct1(words));
    }
}
