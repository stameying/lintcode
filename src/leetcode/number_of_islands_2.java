package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 1/22/16.
 */
public class number_of_islands_2 {

    public List<Integer> numIsland2(int m, int n, int[][] positions){
        List<Integer> res = new ArrayList<Integer>();
        if (m == 0 || n == 0 || positions.length == 0) return res;
        int[] ids = new int[m*n];
        Arrays.fill(ids,-1);
        int size = 0;
        for (int[] position: positions){
            int id = getID(position[0],position[1],n);
            ids[id] = id;
            size++;

            // merge top
            int x = position[0]-1;
            int y = position[1];
            int topId = getID(x,y,n);
            if (isIsland(x,y,m,n,topId,ids)){
                int topRoot = findIslandRoot(ids,topId);
                if (id != topRoot){
                    ids[id] = topRoot;
                    id = topRoot;
                    size--;
                }
            }

            // merge bottom
            x = position[0]+1;
            y = position[1];
            int bottomId = getID(x,y,n);
            if (isIsland(x,y,m,n,bottomId,ids)){
                int bottomRoot = findIslandRoot(ids, bottomId);
                if (id != bottomRoot){
                    ids[id] = bottomRoot;
                    id = bottomRoot;
                    size--;
                }
            }

            // merge left
            x = position[0];
            y = position[1]-1;
            int leftId = getID(x,y,n);
            if (isIsland(x,y,m,n,leftId,ids)){
                int leftRoot = findIslandRoot(ids, leftId);
                if (id != leftRoot){
                    ids[id] = leftRoot;
                    id = leftRoot;
                    size--;
                }
            }

            // merge right
            x = position[0];
            y = position[1]+1;
            int rightId = getID(x,y,n);
            if (isIsland(x,y,m,n,rightId,ids)){
                int rightRoot = findIslandRoot(ids, rightId);
                if (id != rightRoot){
                    ids[id] = rightRoot;
                    id = rightRoot;
                    size--;
                }
            }
            res.add(size);
        }
        return res;
    }

    public int findIslandRoot(int[] ids, int id){
        while (ids[id] != id){
            ids[id] = ids[ids[id]];
            id = ids[id];
        }
        return id;
    }

    public int getID(int x, int y, int n){
        return x*n+y;
    }

    public boolean isIsland(int x, int y , int m, int n, int id, int[] ids){
        return !(x<0||y<0||x>=m||y>=n||ids[id]==-1);
    }
}
