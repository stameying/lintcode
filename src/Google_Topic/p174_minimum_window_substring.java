package Google_Topic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by stameying on 2/17/16.
 */
public class p174_minimum_window_substring {

    public static String minWindow(String s, String t) {

        /*
         * Scan T and store the characters it needs
         */
        Set<Character> set = new HashSet<>();
        int numOfCharInT = 0;
        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if (!set.contains(ch)){
                set.add(ch);
                numOfCharInT++;
            }
        }

//        System.out.println("set size = " + set.size());
        HashMap<Character,Integer> map = new HashMap<>();
        int idx = 0, windowLeft = -1, minWinStart = -1, minLen = s.length()+1;
        int curContainNum = 0;
        while (idx < s.length()){
            char ch = s.charAt(idx);
            if (set.contains(ch)){
                if (curContainNum < numOfCharInT){
                    if (map.containsKey(ch)){
                        map.put(ch,map.get(ch)+1);
//                        System.out.println("ch="+ch+"fr="+map.get(ch));
                    }else{
                        map.put(ch,1);
                        curContainNum++;
                        if (curContainNum == numOfCharInT){
                            int lookBackPos = windowLeft+1;
                            while (lookBackPos <= idx){
                                char tempChar = s.charAt(lookBackPos);
//                                System.out.println("look back pos = " + lookBackPos + " char = " + tempChar );
                                if (!set.contains(tempChar)){
                                    lookBackPos++;
                                }
                                else{
                                    map.put(tempChar,map.get(tempChar)-1);
//                                    System.out.println("redece num = " + tempChar + " fr = " + map.get(tempChar));
                                    if (map.get(tempChar) == 0){
//                                        System.out.println("cur idx="+idx+"remove char = " + tempChar);
                                        map.remove(tempChar);
                                        curContainNum--;
                                        windowLeft = lookBackPos;
                                        int curLen = idx-windowLeft+1;
//                                        System.out.println("curLen="+curLen);
                                        if (curLen < minLen){
                                            minWinStart = windowLeft;
                                            minLen = curLen;
                                        }
                                        break;
                                    }
                                    lookBackPos++;
                                }
                            }
                        }
                    }
                }
            }
            idx++;
        }
        if (minLen == s.length()+1) return "";
        return s.substring(minWinStart,minWinStart+minLen);
    }


    public static void main(String[] args) {
        String s = "A";
        String t = "A";
//        System.out.println(minWindow(s,t));
        int i;
        for (i= 0; i<10;i++){};
        int x = i;
        System.out.println(x);
    }
}
