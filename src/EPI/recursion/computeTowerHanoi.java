package EPI.recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stameying on 2/2/16.
 */
public class computeTowerHanoi {

    public static void computerTower(int numRings){
        List<Deque<Integer>> pegs = new ArrayList<>();
        for (int i = 0; i < numRings; i++){
            pegs.add(new LinkedList<Integer>());
        }

        for (int i = numRings; i >= 1; i--){
            pegs.get(0).add(i);
        }
        computeTowerHanoiSteps(numRings, pegs, 0, 1, 2);
    }

    private static void computeTowerHanoiSteps(int numRingsToMove, List<Deque<Integer>> pegs, int fromPeg, int toPeg, int usePeg){
        if (numRingsToMove > 0){
            computeTowerHanoiSteps(numRingsToMove-1,pegs,fromPeg,usePeg,toPeg);
            int val = pegs.get(fromPeg).removeFirst();
            pegs.get(toPeg).addFirst(val);
            System.out.println("Move from peg " + fromPeg + " to peg " + toPeg + " with " + val);
            computeTowerHanoiSteps(numRingsToMove-1,pegs,usePeg,toPeg,fromPeg);
        }
    }

    public static void main(String[] args) {
        computerTower(3);
    }
}
