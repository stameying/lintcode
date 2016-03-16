//package src.amazon_oa.oa2;
//import src.CodeRound2.display2Dtable;
//import java.util.Arrays;
//
///**
// * Created by stameying on 2/27/16.
// */
//public class rotate_matrix {
//
//
//
//    public static int[][] rotate(int[][] matrix, int n){
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
//
//        int[][] helperMatrix = helper(matrix);
//        flipMatrix(helperMatrix,n);
//        return helperMatrix;
//    }
//
//    public static int[][] helper(int[][] matrix){
//        int m = matrix.length, n = matrix[0].length;
//        int[][] helperMatrix = new int[n][m];
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < m; j++){
//                helperMatrix[i][j] = matrix[j][i];
//            }
//        }
//        return helperMatrix;
//    }
//
//
//    public static void flipMatrix(int[][] matrix, int dir){
//        int m = matrix.length, n = matrix[0].length;
//        if (dir == 1){
//            // clock wise
//		/*
//					1 5          5 1
//		1 2 3 4		2 6   ->>    6 2
//		5 6 7 8		3 7			 7 3
//					4 8 		 8 4
//		*/
//            // flip left and right
//            for (int i = 0; i < m; i++){
//                for (int j = 0; j < n/2; j++){   //  注意要 /2 !
//
//                    swap(matrix,i,j,i,n-1-j);
//                }
//            }
//        }else{
//            // counter-clock wise
//		/*
//					1 5           4 8
//		1 2 3 4		2 6   ->>     3 7
//		5 6 7 8		3 7			  2 6
//					4 8 		  1 5
//		*/
//            for (int i = 0; i < m/2; i++){  //  注意要 /2 !
//                for (int j = 0; j < n; j++){
//                    swap(matrix,i,j,m-1-i,j);
//                }
//            }
//        }
//
//    }
//
//    public static void swap(int[][] matrix, int curX, int curY, int nextX, int nextY){
////        System.out.println("before="+matrix[curX][curY]);
//        matrix[curX][curY] ^= matrix[nextX][nextY];
//        matrix[nextX][nextY] ^= matrix[curX][curY];
//        matrix[curX][curY] ^= matrix[nextX][nextY];
////        System.out.println("after="+matrix[curX][curY]);
//    }
//
//    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4},{5,6,7,8}};
//        display2Dtable.display(rotate(matrix,-1));
//    }
//}
