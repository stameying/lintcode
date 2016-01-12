import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    /**
     * @param map a two demension array represent the suduku map
     */
    public int validSuduku(char[][] map){
        // checker to check each line, col and 3*3 section
        Set<Character> checker = new HashSet<Character>();

        // valid line
        for (int i = 0; i < map.length; i++){
            checker = new HashSet<Character>();
            for (int j = 0; j < map[0].length; j++){
                if (checker.contains(map[i][j])) return 0;
                checker.add(map[i][j]);
            }
        }

        // valid column
        for (int j = 0; j < map[0].length; j++){
            checker = new HashSet<Character>();
            for (int i = 0; i < map.length; i++){
                if (checker.contains(map[i][j])) return 0;
                checker.add(map[i][j]);
            }
        }

        // valid section
        for (int index = 0; index < 9; index++){
            checker = new HashSet<Character>();
            for (int i = index / 3 * 3; i < index / 3 * 3 + 3; i++){
                for (int j = index % 3 * 3; j < index % 3 * 3 + 3; j++){
                    if (checker.contains(map[i][j])) return 0;
                    checker.add(map[i][j]);
                }
            }
        }
        return 1;
    }


    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner scan = new Scanner(System.in);
        // read input into map
        char[][] map = new char[9][9];
        String input = scan.nextLine();
        int count = 0;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                char ch = input.charAt(count++);
                map[i][j] = ch;
            }
        }

        Solution test = new Solution();
        // valid sudoku
        int res = test.validSuduku(map);

        // print result
        System.out.println(res);
    }
}