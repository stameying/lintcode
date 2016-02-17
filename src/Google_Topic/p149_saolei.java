package Google_Topic;

import java.util.Random;

/**
 * Created by stameying on 2/16/16.
 */
public class p149_saolei {


        public static void showMine(int width, int high, int total) {
            int[][] place = new int[high][width];
            Random r = new Random();
            int w, h;
            while (total > 0) {
                w = r.nextInt(width);
                h = r.nextInt(high);
                if (place[h][w] == 0) {
                    place[h][w] = 1;
                    total--;
                }
            }
            for (int i = 0; i < high; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(place[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            showMine(11,12,13);
        }


}
