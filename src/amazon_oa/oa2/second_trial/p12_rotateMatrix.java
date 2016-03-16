//package src.amazon_oa.oa2.second_trial;
//
//import src.CodeRound2.display2Dtable;
//
///**
// * Created by stameying on 2/28/16.
// */
//public class p12_rotateMatrix {
//
//    public static int[][] rotatematrix(int[][] matrix, int n){
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null; // special case
//        int[][] helperMatrix = generateHelperMatrix(matrix);
//        flipMatrix(helperMatrix,n);
//        return helperMatrix;
//    }
//
//    public static void flipMatrix(int[][] matrix, int dir){
//        int m = matrix.length, n = matrix[0].length;
//        if (dir == 1){
//            // clockwise
//            /**
//             1 2 3 4     1 5		5 1
//             5 6 7 8	    2 6		6 2
//             3 7		7 3
//             4 8		8 4
//             */
//            // flip left right
//            for (int i = 0; i < m; i++){
//                for (int j = 0; j < n/2; j++){
//                    swap(matrix,i,j,i,n-1-j);
//                }
//            }
//        }else{
//            for (int i = 0; i < m/2; i++){
//                for (int j = 0; j < n; j++){
//                    swap(matrix,i,j,m-1-i,j);
//                }
//            }
//        }
//    }
//
//    public static void swap(int[][] matrix, int curX, int curY, int nextX, int nextY){
//        matrix[curX][curY] ^= matrix[nextX][nextY];
//        matrix[nextX][nextY] ^= matrix[curX][curY];
//        matrix[curX][curY] ^= matrix[nextX][nextY];
//    }
//
//    public static int[][] generateHelperMatrix(int[][] matrix){
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
//    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4},{5,6,7,8}};
//        display2Dtable.display(rotatematrix(matrix,1));
//    }
//}
