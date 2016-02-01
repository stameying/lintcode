package EPI.HashMap;

import java.util.*;

/**
 * Created by stameying on 2/1/16.
 */
public class findAllSubstrings {

    public static List<Integer> findAllSubstrings(String sentence, List<String> words){
        List<Integer> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (String word: words){
            increment(word,map);
        }
        int unitSize = words.get(0).length();
        for (int i = 0; i + unitSize*words.size() <= sentence.length(); i++){
            if (matchAllwords(sentence,i,words.size(),unitSize,map)){
                res.add(i);
            }
        }
        return res;
    }

    public static void increment(String word, Map<String,Integer> map){
        map.put(word,map.containsKey(word)?map.get(word)+1:1);
    }

    public static boolean matchAllwords(String sentence, int pos, int numWords, int unitSize, Map<String,Integer> map){
        Map<String,Integer> curFreq = new HashMap<>();
        for (int i = 0; i < numWords; i++){
            String word = sentence.substring(pos+i*unitSize, pos+(i+1)*unitSize);
            if (!map.containsKey(word)) return false;
            increment(word,curFreq);
            if (curFreq.get(word) > map.get(word)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("can","apl","ana"));
        String sentence = "amanaplanacanal";
        System.out.println(findAllSubstrings(sentence,words));
    }
}
