package src.first_round;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by stameying on 2/17/16.
 */
public class testSolution1 {

        /**
         * @param words an array of string
         * @param k an integer
         * @return an array of string
         */
        public static String[] topKFrequentWords(String[] words, int k) {
            // Write your code here
            if (k==0) return new String[0];
            HashMap<String,wordNode> map = new HashMap<>();
            PriorityQueue<wordNode> queue = new PriorityQueue<>(k,wordNodeComparator.wordComparator);
            int idx = 0;
            for (String word: words){
                System.out.println("queue size = " + queue.size());
                if (map.containsKey(word)){
                    wordNode node = map.get(word);
                    boolean res = queue.remove(node);
                    System.out.println(idx + "trying to remove " + node.word + " res = " + res);
                    node.count++;
                    res = queue.offer(node);
                    System.out.println(idx + "trying to add " + node.word + " res = " + res);
                }else{
                    wordNode node = new wordNode(word);
                    boolean res = queue.offer(node);
                    System.out.println(idx + "trying to add " + node.word + " res = " + res);
                    map.put(word,node);
                }
                idx++;
            }

            String[] res = new String[k];
            for (int i = 0; i < k; i++){
                res[i] = queue.poll().word;
            }
            return res;
        }


        private static class resComparator implements Comparator<wordNode> {
            @Override
            public int compare(wordNode node1, wordNode node2){
                int res =  Integer.compare(node2.count,node1.count);
                if (res != 0) return res;
                else return node1.word.compareTo(node2.word);
            }

            public static final resComparator wordComparator = new resComparator();
        }

        private static class wordNodeComparator implements Comparator<wordNode>{

            @Override
            public int compare(wordNode node1, wordNode node2){
                int res =  Integer.compare(node2.count,node1.count);
                if (res != 0) return res;
                else return node1.word.compareTo(node2.word);
            }

            public static final wordNodeComparator wordComparator = new wordNodeComparator();
        }


        private static class wordNode {
            public String word;
            public int count;

            public wordNode(String str) {
                this.word = str;
                this.count = 1;
            }
        }


    public static void main(String[] args) {
        String[] words = {"a","b","b","c","c","a","a","a"};
        System.out.println(Arrays.toString(topKFrequentWords(words,2)));
        String s = "ABC";
        s = s.toLowerCase();
        System.out.println(s);
//        System.out.println("tutorial".compareTo("pointer"));
    }
}
