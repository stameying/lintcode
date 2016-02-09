package Google_Topic;

/**
 * Created by stameying on 2/8/16.
 */
public class p48_computerdistance {

    public static int getTotalDistance(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[0][0] += i + j;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");

        for (int i = 1; i < m; i++) {
            matrix[i][0] = matrix[i - 1][0] + (i * n) - (m - i) * n;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i][j - 1] + (j * m) - (n - j) * m;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += matrix[i][j];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] map = {{1,1},{1,1},{1,1}};
        System.out.println(getTotalDistance(3,3));
    }
}
