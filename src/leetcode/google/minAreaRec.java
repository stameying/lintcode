package leetcode.google;

/**
 * Created by stameying on 1/26/16.
 */
public class minAreaRec {
    public int minArea(char[][] image, int x, int y) {
        int left = findLeftBound(image,x,y);

        int right = findRightBound(image,x,y);

        int up = findTopBound(image,x,y);

        int down = findBotBound(image,x,y);

        return (right-left+1)*(down-up+1);
    }

    public int findLeftBound(char[][] image, int x, int y){
        // target is lowest col with a 1, target = 1
        int left = -1, right = y+1;
        while (right - left > 1){
            int mid = left + (right-left)/2;
            boolean containOne = false;
            for (int i = 0; i < image.length; i++){
                if (image[i][mid] == '1'){
                    containOne = true;
                    break;
                }
            }
            if (!containOne){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public int findRightBound(char[][] image, int x, int y){
        // target is highest col with a 1, target = 1
        int left = y-1, right = image[0].length;
        while (right - left > 1){
            int mid = left + (right-left)/2;
            boolean containOne = false;
            for (int i = 0; i < image.length; i++){
                if (image[i][mid] == '1'){
                    containOne = true;
                    break;
                }
            }
            if (!containOne){
                right = mid;
            }else{
                left = mid;
            }
        }
        return left;
    }

    public int findTopBound(char[][] image, int x, int y){
        // target is lowest row with a 1, target = 1
        int left = -1, right = x+1;
        while (right - left > 1){
            int mid = left + (right-left)/2;
            boolean containOne = false;
            for (int j = 0; j < image[0].length; j++){
                if (image[mid][j] == '1'){
                    containOne = true;
                    break;
                }
            }
            if (!containOne){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public int findBotBound(char[][] image, int x, int y){
        // target is highest row with a 1, target = 1
        int left = x-1, right = image.length;
        while (right - left > 1){
            int mid = left + (right-left)/2;
            boolean containOne = false;
            for (int j = 0; j < image[0].length; j++){
                if (image[mid][j] == '1'){
                    containOne = true;
                    break;
                }
            }
            if (!containOne){
                right = mid;
            }else{
                left = mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        minAreaRec test = new minAreaRec();
        char[][] grid = {{'0','0','1','0'},
                {'0','1','1','0'},
                {'0','1','0','0'}};
        System.out.println(test.minArea(grid,0,2));
    }
}
