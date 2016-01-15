package leetcode.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by stameying on 1/14/16.
 */
public class Minimum_Height_Tree {

    /*
    * 生成一个图
    * 找到所有的leaves,然后从图里删除这些leaves,生成新的leaves
    * 直到当前图里只剩下一个或者两个node
    * */
    public List<Integer> findMinHeightTree(int n, int[][] edges){
        List<Integer> res = new ArrayList<Integer>();

        List<Set<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) map.add(new HashSet<Integer>());

        for (int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            map.get(from).add(to);
            map.get(to).add(from);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (map.get(i).size()==1) leaves.add(i);
        }

        while (n > 2){
            n-=leaves.size();
            List<Integer> newleaves = new ArrayList<>();
            for (Integer leaf: leaves){
                Integer candidateLeaf = map.get(leaf).iterator().next();
                map.get(candidateLeaf).remove(leaf);
                if (map.get(candidateLeaf).size()==1){
                    newleaves.add(candidateLeaf);
                }
            }
            leaves = newleaves;
        }
        return leaves;
    }


    public static void main(String[] args) {

    }
}
