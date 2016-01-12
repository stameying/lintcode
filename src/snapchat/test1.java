package snapchat;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by stameying on 1/11/16.
 */
public class test1 {

    public int validSuduku(int[][] map){
        Set<Integer> checker = new HashSet<Integer>();
        // valid line
        for (int i = 0; i < map.length; i++){
            checker = new HashSet<Integer>();
            for (int j = 0; j < map[0].length; j++){
                if (checker.contains(map[i][j])) return 0;
                checker.add(map[i][j]);
            }
        }

        // valid column
        for (int j = 0; j < map[0].length; j++){
            checker = new HashSet<Integer>();
            for (int i = 0; i < map.length; i++){
                if (checker.contains(map[i][j])) return 0;
                checker.add(map[i][j]);
            }
        }

        // valid section
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                checker = new HashSet<Integer>();
                for (int x = 3*i; x < 3*i+3; x++){
                    for (int y = 3*j; y < 3*j+3; y++){
                        if (checker.contains(map[x][x])) return 0;
                        checker.add(map[x][x]);
                    }
                }
            }
        }


        return 1;
    }


    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int[][] map = new int[9][9];
        String input = scan.nextLine();
        System.out.println(input);
        int count = 0;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                char ch = input.charAt(count++);
                System.out.println(ch);
                map[i][j] = ch-'0';
            }
        }

        test1 test = new test1();
        System.out.println(test.validSuduku(map));;

        // valid line

    }
}
