package src.first_round;

/**
 * Created by stameying on 12/14/15.
 */
public class search_2D_matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix.length == 0) return false;
        int rowNum = 0;
        while (rowNum < matrix.length-1){
            if (matrix[rowNum][0] == target) return true;
            if (rowNum != matrix.length-1){
                if (matrix[rowNum][0] < target && matrix[rowNum+1][0] > target){
                    break;
                }
            }
            rowNum++;
        }
        int left = 0, right = matrix[0].length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            System.out.println("mid="+mid);
            System.out.println("rowNum="+rowNum);
            if (matrix[rowNum][mid] == target) return true;
            else if (matrix[rowNum][mid] < target) left++;
            else right--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[1][1];
        input[0][0] = 5;
        System.out.println(searchMatrix(input,2));
    }
}
