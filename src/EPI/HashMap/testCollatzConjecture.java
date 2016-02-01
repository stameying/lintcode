package EPI.HashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by stameying on 2/1/16.
 */
public class testCollatzConjecture {
    public static boolean testCollatzConjecture(int n){
        Set<Long> verifiedNumber = new HashSet<>();
        verifiedNumber.add((long)1);
        verifiedNumber.add((long)2);
        for (int i = 3; i <= 3; i++){
            Set<Long> sequence = new HashSet<>();
            long testI = i;
            while (testI >= i){
                if (!sequence.contains(testI)){
                    sequence.add(testI);
                }else return false;

                if ((testI % 2) != 0) {
                    if (!verifiedNumber.contains(testI)) {
                        verifiedNumber.add(testI);
                    } else break;
                    long nextTestI = 3 * testI + 1;
                    if (nextTestI <= testI){
                        throw new ArithmeticException("Collatz sequence overflow for" + i);
                    }
                    testI = nextTestI;
                }else{
                    testI /= 2;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        testCollatzConjecture test = new testCollatzConjecture();
    }
}
