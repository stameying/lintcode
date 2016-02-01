package EPI.HashMap;

import java.util.*;

/**
 * Created by stameying on 1/31/16.
 */
public class findSmallestSubarray {

    private static class Subarray{
        public Integer start;
        public Integer end;

        public Subarray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Subarray findSmallest(List<String> paragraphs, List<String> keywords){
        Map<String,Integer> map = new HashMap<>();
        Subarray res = new Subarray(-1,-1);
        for (int left = 0, right = 0; right < paragraphs.size();){
            for (; right<paragraphs.size() && map.size() < keywords.size(); right++){
                if (keywords.contains(paragraphs.get(right))){
                    map.put(paragraphs.get(right), map.containsKey(paragraphs.get(right))? map.get(paragraphs.get(right))+1:1);
                }
            }

            for (; left < right && map.size() == keywords.size(); left++){
                if (keywords.contains(paragraphs.get(left))){
                    int keywordCount = map.get(paragraphs.get(left));
                    keywordCount--;
                    if (keywordCount == 0){
                        map.remove(paragraphs.get(left));
                        if ((res.start==-1 && res.end == -1) || right-1-left < res.end-res.start){
                            res.start = left;
                            res.end = right-1;
                        }
                    }else{
                        map.put(paragraphs.get(left),keywordCount);
                    }

                }
            }
        }
        return res;
    }

    public static String findSmallestSubarray(List<String> paragraphs, List<String> words){
        HashMap<String,Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int minStart = -1, minEnd = -1;
        for (; right < paragraphs.size();){
//            System.out.println("right="+right);
            for (; right < paragraphs.size() && map.size() < words.size();right++){
                System.out.println("size="+map.size());
                String word = paragraphs.get(right);
                if (words.contains(word)){
                    if (map.containsKey(word)){
                        map.put(word,map.get(word)+1);
                    }else{
                        map.put(word,1);
                    }
                }
            }

            // covers all the words
            for (; left < right && map.size() == words.size(); left++){
                String word = paragraphs.get(left);
                System.out.println("word = " + word);
                System.out.println("map size = " + map.size());
                System.out.println(words.contains("banana"));
                if (words.contains(word)){
                    System.out.println("key word contains " + paragraphs.get(left));
                    int frequency = map.get(word);
                    frequency--;
                    if (frequency == 0){
                        map.remove(word);
                        if (minStart==-1 && minEnd==-1){
                            minStart = left;
                            minEnd = right;
                        }else if (minEnd-minStart+1 > right-left+1){
                            minStart = left;
                            minEnd = right;
                        }
                    }else{
                        map.put(word,frequency);
                    }
                }
                System.out.println("map size2 = " + map.size());
            }
        }
        return minStart + "->" + (minEnd-1);
    }


    public static void main(String[] args) {
        List<String> paragraph = new ArrayList<>(Arrays.asList("apple","banana","apple","peer","banana"));
        List<String> keyowrds = new ArrayList<>(Arrays.asList("banana","peer"));
        System.out.println(findSmallestSubarray(paragraph,keyowrds));
    }
}
