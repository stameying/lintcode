package EPI.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 1/29/16.
 */
public class rotateImage {

    public static void rotate(int[][] matrix) {
        final int size = matrix.length-1;
        for (int i = 0; i <= size/2; ++i){
            for (int j = i; j < size-i; ++j){
                int temp1 = matrix[size-j][i];
                int temp2 = matrix[size-i][size-j];
                int temp3 = matrix[j][size-i];
                int temp4 = matrix[i][j];
                System.out.println("i="+i+" j="+j);
                matrix[i][j] = temp1;
                matrix[size-j][i] = temp2;
                matrix[size-i][size-j] = temp3;
                matrix[j][size-i] = temp4;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2},{3,4}};
        rotate(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        List<Integer> res = new ArrayList<>(4);
    }
}
