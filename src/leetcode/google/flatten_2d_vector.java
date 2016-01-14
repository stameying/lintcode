package leetcode.google;

import java.util.List;

/**
 * Created by stameying on 1/13/16.
 */
public class flatten_2d_vector {

    int x,y;
    List<List<Integer>> vec2d;
    public flatten_2d_vector(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        x = 0;
        while (x < vec2d.size() && vec2d.get(x).size() == 0) x++;
        y = 0;
    }

    public int next(){
        int res = vec2d.get(x).get(y++);
        if (y == vec2d.get(x).size()){
            y = 0;
            x++;
            while (x < vec2d.size() && vec2d.get(x).size() == 0) x++;
        }
        return res;
    }

    public boolean hasNext(){
        return x < vec2d.size() && y < vec2d.get(x).size();
    }
}
