package EPI.Greedy;

import java.util.*;

/**
 * Created by stameying on 2/6/16.
 */
public class huffmanCode {

    public class CharWithFrenquency{
        public char c;
        public double freq;
        public String code;
    }

    public static class BinaryTree implements Comparable<BinaryTree>{
        public double aggregateFreq;
        public CharWithFrenquency s;
        public BinaryTree left, right;

        public BinaryTree(double aggregateFreq, CharWithFrenquency s, BinaryTree left, BinaryTree right) {
            this.aggregateFreq = aggregateFreq;
            this.s = s;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(BinaryTree o) {return Double.compare(aggregateFreq,o.aggregateFreq)};

        @Override
        public boolean equals(Object obj){
            if (obj == null || !(obj instanceof BinaryTree)) return false;
            return this==obj || this.aggregateFreq == ((BinaryTree) obj).aggregateFreq;
        }

        @Override
        public int hashCode() {return Objects.hash(aggregateFreq)};
    }


    public static Map<Character, String> huffmanEncoding(List<CharWithFrenquency> symbols){
        PriorityQueue<BinaryTree> candidates = new PriorityQueue<>();
        for (CharWithFrenquency s: symbols) candidates.add(new BinaryTree(s.freq, s, null,null));

        while (candidates.size() > 1){
            BinaryTree left = candidates.poll();
            BinaryTree right = candidates.poll();
            candidates.add(new BinaryTree(left.aggregateFreq+right.aggregateFreq, null, left,right));
        }

        Map<Character,String> encoding = new HashMap<>();

        assignCode(candidates.peek(), new StringBuilder(), encoding);
        return encoding;
    }

    public static void assignCode(BinaryTree tree, StringBuilder code, Map<Character,String> map){
        if (tree != null){
            if (tree.s != null){
                map.put(tree.s.c, code.toString());
            }else{
                code.append('0');
                assignCode(tree.left, code, map);
                code.setLength(code.length()-1);
                code.append('1');
                assignCode(tree.right,code,map);
                code.setLength(code.length()-1);
            }
        }
    }
}
