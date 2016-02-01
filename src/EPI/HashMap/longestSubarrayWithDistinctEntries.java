package EPI.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by stameying on 2/1/16.
 */
public class longestSubarrayWithDistinctEntries {

    public static int longestSubarrayWithDistinctEntries(List<Character> A){
        HashMap<Character,Integer> map = new HashMap<>();
        int start = -1, maxLen = 0;
        for (int i = 0; i < A.size(); i++){
            if (!map.containsKey(A.get(i))){
                map.put(A.get(i),i);
            }else{
                int lastSee = map.get(A.get(i));
                int localLen = (i-start)-1;
                if (localLen > maxLen){
                    maxLen = localLen;
                }
                start = lastSee;
                map.put(A.get(i),i);
            }
        }
        int localLen = A.size()-start-1;
        if (localLen > maxLen) maxLen = localLen;
        System.out.println("max len = " + maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        char[] arr = "fsfetwenwe".toCharArray();
        Character[] arr2 = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) arr2[i] = arr[i];
        List<Character> list = new ArrayList<>(Arrays.asList(arr2));
        System.out.println(longestSubarrayWithDistinctEntries(list));
    }
}
