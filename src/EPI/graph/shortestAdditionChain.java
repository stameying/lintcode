package EPI.graph;

import java.util.*;

/**
 * Created by stameying on 2/6/16.
 */
public class shortestAdditionChain {

    public static List<Integer> shortestAdditionChain(int n){
        if (n==1) return Arrays.asList(1);
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(1));
        while(!queue.isEmpty()){
            System.out.println("current queue size = " + queue.size() + " candidate="+queue.peek());
            List<Integer> candidate = queue.poll();

            for (int a : candidate){
                int sum = a + candidate.get(candidate.size()-1);
                if (sum > n) break;
                List<Integer> newChain = new ArrayList<>(candidate);
                newChain.add(sum);
                if (sum == n) return newChain;
                queue.offer(newChain);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(shortestAdditionChain(15));
    }
}
