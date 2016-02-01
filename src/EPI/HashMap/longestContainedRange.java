package EPI.HashMap;

import java.util.*;

/**
 * Created by stameying on 2/1/16.
 */
public class longestContainedRange {

    /***
     *
     * O(nlogn)
     *
     */
    public static int longestContainedRange(List<Integer> A){
        Collections.sort(A);
        int maxLen = 1, curStart = 0, curLen = 1;
        for (int i = 1; i < A.size(); i++){
            if (A.get(i-1)+1 == A.get(i)){
                curLen++;
            }else{
                maxLen = Math.max(curLen,maxLen);
                curStart = i;
                curLen = 1;
            }
        }
        maxLen = Math.max(curLen,maxLen);
        return maxLen;
    }


    /**
     * O(n)
     * */

    public static int longestContainedRange2(List<Integer> A){
        Set<Integer> unprocessedEntries = new HashSet<>(A);
        int maxIntervalSize = 0;
        while (!unprocessedEntries.isEmpty()){
            int a = unprocessedEntries.iterator().next();
            unprocessedEntries.remove(a);

            // move both directions
            int lowerBound = a-1;
            while (unprocessedEntries.contains(lowerBound)){
                unprocessedEntries.remove(lowerBound);
                lowerBound--;
            }

            int upBound = a+1;
            while (unprocessedEntries.contains(upBound)){
                unprocessedEntries.remove(upBound);
                upBound++;
            }
            System.out.println(upBound + ";" + lowerBound);
            maxIntervalSize = Math.max(maxIntervalSize, upBound-lowerBound-1);
        }
        return maxIntervalSize;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3,-2,7,9,8,1,2,0,-1,5,8));
        System.out.println(longestContainedRange2(list));
    }
}
