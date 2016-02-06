package EPI.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by stameying on 2/4/16.
 */
public class searchMaze {

    public static class Coordinate{
        public int x,y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){
            if (o == null || !(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate)o;
            return this==o||(x == that.x && y == that.y);
        }

        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }

    }

    public static enum Color {WHITE,BLACK};

    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate s, Coordinate e){
        List<Coordinate> path = new ArrayList<>();
        maze.get(s.x).set(s.y, Color.BLACK);
        path.add(s);
        if (!searchHelper(maze,s,e,path)){
            path.remove(path.size()-1);
        }
        return path;
    }

    public static boolean searchHelper(List<List<Color>> maze, Coordinate cur, Coordinate e, List<Coordinate> path){
        if (cur.equals(e)) return true;
        final List<List<Integer>> SHIFT = Arrays.asList(Arrays.asList(0,1),Arrays.asList(0,-1),Arrays.asList(1,0),Arrays.asList(-1,0));

        for (List<Integer> s : SHIFT){
            Coordinate next = new Coordinate(cur.x + s.get(0), cur.y + s.get(1));
            if (isFeasible(next,maze)){
                maze.get(next.x).set(next.y, Color.BLACK);
                path.add(next);
                if (searchHelper(maze,next,e,path)) return true;
                path.remove(path.size()-1);
            }
        }
        return false;
    }

    private static boolean isFeasible(Coordinate cur, List<List<Color>> maze){
        return cur.x >= 0 && cur.x < maze.size() && cur.y >= 0 && cur.y < maze.get(cur.x).size() && maze.get(cur.x).get(cur.y) == Color.WHITE;
    }

}
