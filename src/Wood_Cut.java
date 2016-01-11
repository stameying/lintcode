/**
 * Created by stameying on 1/9/16.
 */
public class Wood_Cut {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int low = 0, high = 0;
        for (int i = 0; i < L.length; i++){
            if (L[i] > high) high = L[i];
        }
        int best = 0;
        while (low < high){
            System.out.println("low="+low+",high="+high);
            int tempCount = 0;
            int mid = low + (high-low)/2;
            for (int i = 0; i < L.length; i++){
                tempCount += L[i]/mid;
            }
            if (tempCount < k){
                high = mid-1;
            }else if (tempCount > k){
                low = mid+1;
            }else{
                if (mid > best) best = mid;
                low = mid+1;
            }
        }
        System.out.println("best="+best);
        return low;

    }

    public static void main(String[] args) {
        int[] L = {232,124,456};
        Wood_Cut test = new Wood_Cut();
        test.woodCut(L,7);
    }
}
