package EPI.Dynamic_Programming;

import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 2/4/16.
 */
public class pretty_print {

    public static int minimumMessiness_temp(List<String> words, int lineLength){
        // minimumMessiness[i] is the minimum messiness when placing word[0:i]
        int[] minimumMessiness = new int[words.size()];
        Arrays.fill(minimumMessiness,Integer.MAX_VALUE);
        int numRemainingBlanks = lineLength - words.get(0).length();
        minimumMessiness[0] = numRemainingBlanks * numRemainingBlanks;

        for (int i = 1; i < words.size(); i++){
            numRemainingBlanks = lineLength - words.get(i).length();
            minimumMessiness[i] = minimumMessiness[i-1] + numRemainingBlanks * numRemainingBlanks;
            for (int j = i-1; j >= 0; j--){
                numRemainingBlanks -= (words.get(j).length()+1);
                if (numRemainingBlanks < 0) break; // not enough space
                int firstJMessiness = j-1 < 0? 0 : minimumMessiness[j-1];
                int currentLineMessiness = numRemainingBlanks * numRemainingBlanks;
                minimumMessiness[i] = Math.min(minimumMessiness[i], firstJMessiness + currentLineMessiness);
            }
        }
        return minimumMessiness[words.size()-1];
    }


    public static int minimumMessiness(List<String> words, int lineLength){
        int[] M = new int[words.size()];
        Arrays.fill(M, Integer.MAX_VALUE);
        int blanks = lineLength-words.get(0).length();
        M[0] = getValue(blanks);
        for (int i = 1; i < words.size(); i++){
            blanks = lineLength - words.get(i).length();
            M[i] = M[i-1] + getValue(blanks);
            for (int j = i-1; j >= 0; j--){
                blanks -= (words.get(j).lastIndexOf(+1));
                if (blanks < 0) break;
                int firstJMessiness = j < 1? 0:M[j-1];
                int curMess = getValue(blanks);
                M[i] = Math.min(M[i], firstJMessiness+curMess);
            }
        }
        return M[words.size()-1];
    }

    public static int minimumMess(List<String> words, int lineLength){
        int[] M = new int[words.size()];
        Arrays.fill(M, Integer.MAX_VALUE);
        int blanks = lineLength- words.get(0).length();
        M[0] = getValue(blanks);
        for (int i = 1; i < words.size(); i++){
            blanks -= words.get(i).length();
            M[i] = M[i-1] + getValue(blanks);
            for (int j = i-1; j >= 0; j--){
                blanks -= (words.get(j).length()+1);
                if (blanks < 0) break;
                int firstJMess = j < 1? 0 : M[j-1];
                int curMess = getValue(blanks);
                M[i] = Math.min(M[i], firstJMess+curMess);
            }

        }
        return M[words.size()-1];
    }

    public static int getValue(int n){
        return (int)Math.pow(n,2);
    }

    public static void main(String[] args) {

    }
}
