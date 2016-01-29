package EPI.array;

import java.util.Collections;
import java.util.List;

/**
 * Created by stameying on 1/28/16.
 */
public class nextPermutation {

    public static List<Integer> nextPermutation(List<Integer> perm){
        int pos = perm.size()-2;
        while (pos >= 0 && perm.get(pos) >= perm.get(pos+1)) pos--;
        if (pos == -1) return null;
        int swapPos = perm.size()-1;
        while (swapPos > pos && perm.get(swapPos) <= perm.get(pos)) swapPos--;
        Collections.swap(perm,pos,swapPos);
        Collections.reverse(perm.subList(pos+1,perm.size()));
        return perm;
    }
}
