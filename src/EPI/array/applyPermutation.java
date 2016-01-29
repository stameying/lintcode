package EPI.array;

import java.util.Collections;
import java.util.List;

/**
 * Created by stameying on 1/28/16.
 */
public class applyPermutation {

    /**
     * A = [a,b,c,d]
     * P = [2,0,1,3]
     * A =>[b,c,a,d]
     * */
    public static void applyPermutation(List<Integer> perm, List<Integer> A){
        for (int i = 0; i < A.size(); i++){
            int next = i;
            while (perm.get(next) >= 0){
                Collections.swap(A, i, perm.get(next));
                int temp = perm.get(next);
                // subtract size from perm to indicate it has been performed
                perm.set(next,perm.get(next)-perm.size());
                next = temp;
            }
        }
        for (int i = 0; i < perm.size(); i++){
            perm.set(i,perm.get(i)+perm.size());
        }
    }
}
