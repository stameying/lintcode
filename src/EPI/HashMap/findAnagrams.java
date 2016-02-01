package EPI.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by stameying on 1/31/16.
 */
public class findAnagrams {

    public static List<List<String>> findAnagram(List<String> dictionary){
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word: dictionary){
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String hashKey = new String(charArr);
            if (!map.containsKey(hashKey)){
                List<String> anagram = new ArrayList<>();
                anagram.add(word);
                map.put(hashKey,anagram);
            }else{
                List<String> anagram = map.get(hashKey);
                anagram.add(word);
                map.put(hashKey,anagram);
            }
        }
        for (List<String> anagram: map.values()){
            if (anagram.size() > 1){
                res.add(anagram);
            }
        }
        return res;
    }
}
