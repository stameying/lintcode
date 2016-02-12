package Google_Topic;

import java.util.*;

/**
 * Created by stameying on 2/10/16.
 */
public class p90_stringsort {

    private static class compare implements Comparator<String> {
        @Override
        public int compare(String s1, String s2){
            if (s1.length() == 0 && s2.length() == 0) return 0;
            else if (s1.length() == 0 && s2.length() != 0) return -1;
            else if (s1.length() != 0 && s2.length() == 0) return 1;
            int p1 = 0, p2 = 0;
            while (p1 < s1.length() && p2 < s2.length()){
                if (s1.charAt(p1) == s2.charAt(p2)){
                    p1++;
                    p2++;
                }else if (s1.charAt(p1) > s2.charAt(p2)) return 1;
                else return -1;
            }
            if (p1 == s1.length() && p2 != s2.length()) return -1;
            else if (p1 != s1.length() && p2 == s2.length()) return 1;
            return 0;
        }

        public static final compare STRINGCOMPARE = new compare();
    }

    public static List<String> sortString(List<String> words){
        Collections.sort(words, compare.STRINGCOMPARE);
        return words;
    }

    public static void main(String[] args) {
//        List<String> words = new ArrayList<>();
//        words.add("bca");
//        words.add("bcc");
//        words.add("bac");
//        words.add("acv");
//        words.add("acc");
//        sortString(words);
//        System.out.println(words);
        List<String> test = new ArrayList<>(Arrays.asList("cbb","gd","ba","ac"));
        System.out.println("size="+test.size());
//        Collections.sort(test, compare.STRINGCOMPARE);
        System.out.println(sortString(test));
    }

}
