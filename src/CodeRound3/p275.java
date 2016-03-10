package src.CodeRound3;

/**
 * Created by stameying on 3/9/16.
 */
public class p275 {


    public static int hIndex(int[] citations) {
        // citations[index] >= length(citations) - index
        if (citations.length == 0) return 0;
        int left = 0, right = citations.length-1;
        while (left + 1 < right){
            int mid = left + (right-left)/2;
            if (citations[mid] == (citations.length-mid)) return citations.length-mid;
            else if (citations[mid] > (citations.length-mid)) right = mid;
            else left = mid;
        }
//        System.out.println("citation left = " + citations[left] + ", citaionlength-left="+(citations.length-left));
//        System.out.println("citation right = " + citations[right] + ", citaionlength-right="+(citations.length-right));
        if (citations[left] >= (citations.length-left)) return (citations.length-left);
        if (citations[right] >= (citations.length-right)) return (citations.length-right);
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {100};
        System.out.println(hIndex(citations));
    }
}
