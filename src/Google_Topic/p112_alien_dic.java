package Google_Topic;

import java.util.*;

/**
 * Created by stameying on 2/13/16.
 */
public class p112_alien_dic {

    public String alienOrder(String[] words){
        //节点构成的图
        Map<Character,Set<Character>> graph = new HashMap<Character,Set<Character>>();
        //节点的计数器
        Map<Character,Integer> indegree = new HashMap<Character,Integer>();
        //结果
        StringBuilder builder = new StringBuilder();
        //初始化图和计数器
        initialize(words,graph,indegree);
        //建图并更新相应的计数器
        buildGraph(words,graph,indegree);
        //拓扑排序
        topologicalSort(builder,graph,indegree);
        //如果大小相等等于没有环
        return builder.length()==indegree.size()?builder.toString():"";

    }

    /**
     * initialize graph and indregg counter
     * */
    public void initialize(String[] words, Map<Character,Set<Character>> graph, Map<Character,Integer> indegree){
        for (String word: words){
            for (int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if (!graph.containsKey(ch)){
                    Set<Character> set = new HashSet<>();
                    graph.put(ch,set);
                }
                if (!indegree.containsKey(ch)){
                    indegree.put(ch,0);
                }
            }
        }
    }


    /**
     * generate graph and update each node's indgree
     * */
    public void buildGraph(String[] words, Map<Character,Set<Character>> graph, Map<Character,Integer> indegree){
        Set<String> edges = new HashSet<>(); // a set contains all generated edges
        for (int i = 0; i < words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            for (int j = 0; j < word1.length() && j < word2.length(); j++){
                char from = word1.charAt(j);
                char to = word2.charAt(j);
                if (from == to) continue;
                // 确认这条边有没有用过
                if (!edges.contains(from+"->"+to)){
                    // 更新图
                    Set<Character> set = graph.get(from);
                    set.add(to);
                    graph.put(from,set);
                    // 更新to的计数器
                    indegree.put(to,indegree.get(to)+1);
                    // 将当前的边加到集合里
                    edges.add(from+"->"+to);
                    break;
                }
            }
        }
    }

    /**
     * 拓扑排序
     * */
    public void topologicalSort(StringBuilder builder, Map<Character,Set<Character>> graph, Map<Character,Integer> indegree ){
        // BFS
        Queue<Character> queue = new LinkedList<>();
        // 加入所有indegree为0的点
        for (Character ch: indegree.keySet()){
            if (indegree.get(ch) == 0){
                queue.offer(ch);
            }
        }
        while (!queue.isEmpty()){
            Character ch = queue.poll();
            builder.append(ch);
            Set<Character> toSet = graph.get(ch);
            if (toSet != null){
                for (Character next: toSet){
                    int val = indegree.get(next);
                    val--;
                    indegree.put(next,val);
                    if (val == 0){
                        queue.offer(next);
                    }
                }
            }
        }
    }
}
