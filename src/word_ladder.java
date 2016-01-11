import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by stameying on 1/9/16.
 */
public class word_ladder {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict.size()==0) return 0;
        Queue<node> queue = new LinkedList<node>();
        Set<String> expanded = new HashSet<String>();
        queue.offer(new node(start,1));
        expanded.add(start);
        dict.add(end);
        while (!queue.isEmpty()){
            node cur = queue.poll();
            if (cur.name.equals(end)) return cur.depth;
            for (int i = 0; i < cur.name.length(); i++){
                StringBuilder curStr = new StringBuilder(cur.name);
                char oldChar = curStr.charAt(i);
                for (char ch = 'a'; ch <= 'z'; ch++){
                    if (ch == oldChar) continue;
                    else{
                        curStr.setCharAt(i,ch);
                        if (dict.contains(curStr.toString()) && !expanded.contains(curStr.toString())){
                            System.out.println(curStr.toString()+","+(cur.depth+1));
                            queue.offer(new node(curStr.toString(), cur.depth+1));
                            expanded.add(curStr.toString());
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        word_ladder test = new word_ladder();
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        test.ladderLength("hit","cog",dict);
    }
}

class node{
    String name;
    int depth;
    public node(String name, int depth){
        this.name = name;
        this.depth = depth;
    }
}
