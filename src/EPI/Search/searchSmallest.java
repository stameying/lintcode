package EPI.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 1/31/16.
 */
public class searchSmallest {

    public static int searchSmallest(List<Integer> list){
        int left = 0, right = list.size()-1;
        while (left < right){
            int mid = left + (right-left)/2;
            if (list.get(mid) < list.get(right)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(378,478,550,631,103,203,220,234,279,368));
//        System.out.println(searchFirstOfK(A,109));
        System.out.println(searchSmallest(A));
    }
}
