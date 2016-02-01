package EPI.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by stameying on 1/31/16.
 */
public class nearestRepetition {

    public static int findNearestRepetition(List<String> paragraphs){
        HashMap<String,Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < paragraphs.size(); i++){
            String word = paragraphs.get(i);
            if (!map.containsKey(word)){
                map.put(word,i);
            }else{
                int localDistance = (i-map.get(word));
                if (localDistance < minDistance){
                    minDistance = localDistance;
                }
                map.put(word,i);
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        List<String> paragraphs = new ArrayList<>(Arrays.asList("All","word","and","no","play","makes","for","no","work","no","fun","and","no","results"));
        System.out.println(findNearestRepetition(paragraphs));
    }
}
