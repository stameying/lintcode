package src.first_round;

/**
 * Created by stameying on 12/11/15.
 */
public class zigzag_travelsal {

    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        if (matrix.length == 1) return matrix[0];
        if (matrix[0].length == 1){
            int[] res = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++){
                res[i] = matrix[i][0];
            }
            return res;
        }

        int[] res = new int[matrix.length*matrix[0].length];
        int x = 0, y = 0, count = 0, direction = 1;
        while (count < matrix.length*matrix[0].length){
            res[count] = matrix[x][y];
            if ( direction == 1){ // going up
                if (y == matrix[0].length-1){ // hit right bound
                    x++;
                    direction = -1;
                }else if (x == 0){ // hit first row
                    y++;
                    direction = -1;
                }else{ // going right top
                    x--;
                    y++;
                }
            }else{ // going down
                if (x == matrix.length-1){ // hit bottom
                    y++;
                    direction = 1;
                }else if (y == 0){ // hit left bound
                    x++;
                    direction = 1;
                }else{ // going left bottom
                    x++;
                    y--;
                }
            }
            count++;
        }
        displayRow(res);
        return res;
    }

    public void displayRow(int[] res){
        for (int i = 0; i < res.length; i++){
            System.out.print(res[i]);
            if (i != res.length - 1){
                System.out.print(',');
            }
        }
    }

    public static void main(String args[]){
        int[] row1 = {1,2,3,4};
        int[] row2 = {5,6,7,8};
        int[] row3 = {9,10,11,12};
        int[][] matrix = new int[3][4];
        matrix[0] = row1;
        matrix[1] = row2;
        matrix[2] = row3;

        zigzag_travelsal test = new zigzag_travelsal();
        test.printZMatrix(matrix);

    }
}
