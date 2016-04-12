package src.Google_Topic.Onsite;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stameying on 4/6/16.
 */
public class trapping_water_2 {

    public static final int[][] direction = new int[][]{
            new int[]{-1,0},
            new int[]{1,0},
            new int[]{0,-1},
            new int[]{0,1}
    };

    public static class Cell{
        public int x;
        public int y;
        public int h;

        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        public int getH(){
            return this.h;
        }
    }

    private static class MyComparator implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2){
            return Integer.compare(c1.h,c2.h);
        }
    }


    public static int solution(int[][] map){

        int m = map.length, n = map[0].length;
        int[][] visited = new int[m][n];

        PriorityQueue<Cell> queue = new PriorityQueue<>(new MyComparator());

        for (int i = 0; i < m; i++){
            queue.offer(new Cell(i,0,map[i][0]));
            queue.offer(new Cell(i,n-1,map[i][n-1]));
            visited[i][0] = 1;
            visited[i][n-1] = 1;
        }

        for (int j = 0; j < n; j++){
            queue.offer(new Cell(0,j,map[0][j]));
            queue.offer(new Cell(m-1,j,map[m-1][j]));
            visited[0][j] = 1;
            visited[m-1][j] = 1;
        }

        int res = 0;
        while (!queue.isEmpty()){
            Cell cur = queue.poll();
            System.out.println("cur = [" + cur.x + "," + cur.y + "]");
            for (int[] dir: direction){
                int nextX = cur.x + dir[0];
                int nextY = cur.y + dir[1];
                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && visited[nextX][nextY] == 0){
                    visited[nextX][nextY] = 1;
                    queue.offer(new Cell(nextX,nextY,Math.max(cur.h,map[nextX][nextY])));
                    System.out.println("next = [" + nextX + "," + nextY + "]");
                    if (cur.h-map[nextX][nextY] > 0){
                        res += cur.h-map[nextX][nextY];
                        System.out.println(cur.h-map[nextX][nextY]);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{
                {12,13,0,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13}
        };
        System.out.println(solution(map));
    }


}
