package Google_Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/10/16.
 */
public class p75_tail_recursion {

    public static String match(int n){
        List<String> matches = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            matches.add(Integer.toString(i));
        }
        String[] res = new String[1];
        helpMatch(matches,res);
        return res[0];
    }

    public static void helpMatch(List<String> matches, String[] res){
        if (matches.size() == 1){
            res[0] = matches.get(0);
            return;
        }
        List<String> newMatches = new ArrayList<>();
        int len = matches.size();
        for (int i = 0; i < len/2; i++){
            newMatches.add("(" + matches.get(i) + "," + matches.get(len-1-i) + ")");
        }
        System.out.println("new Match = " + newMatches);
        helpMatch(newMatches, res);
    }

    public static void main(String[] args) {
        System.out.println(match(8));
    }
}
