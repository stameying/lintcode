package EPI.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 1/31/16.
 */
public class searchFirstOfK {

    public static int searchFirstOfK(List<Integer> A, int k){
        int left = 0, right = A.size()-1, res = -1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if (A.get(mid) == k){
                res = mid;
                right = mid-1;
            }else if (A.get(mid) < k){
                left = mid+1;
            }else{ // mid > k
                right = mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(-14,-10,2,109,109,243,285,285,285,401));
//        System.out.println(searchFirstOfK(A,109));
//        System.out.println(searchFirstLargerThanK(A,285));
    }
}
