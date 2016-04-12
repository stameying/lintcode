package src.Google_Topic.Onsite;

/**
 * Created by stameying on 4/5/16.
 */
public class kmp {

    public int[] buildPMT(char[] arr){
        int[] pmt = new int[arr.length];
        int i = 1, j = 0;
        while (i < arr.length){
            if (arr[i] == arr[j]){
                pmt[i++] = ++j;
            }else{
                if (j == 0){
                    pmt[i++] = 0;
                }else{
                    j = pmt[j-1];
                }
            }
        }

        String str = "";
        return pmt;
    }
}
