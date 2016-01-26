package leetcode.google;

/**
 * Created by stameying on 1/26/16.
 */
public class strStr {

    private static int strStr(String haystack, String needle) {
        return search(haystack,needle);
    }

    private static int[] buildPMT(String pattern){
        char[] array = pattern.toCharArray();
        int[] pmt = new int[array.length];
        int i = 1, j = 0;
        while ( i < array.length){
            if (array[i] == array[j]){
                pmt[i++] = j+1;
                j++;
            }else{
                if (j == 0){
                    pmt[i] = 0;
                    i++;
                }else{
                    j = pmt[j-1];
                }
            }
        }
        return pmt;
    }

    private static int search(String haystack, String needle){
        int[] pmt = buildPMT(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()){
            System.out.println("i="+i+" j="+j);
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                if (j != 0){
//                    i+=(needle.length()-pmt[j-1]);
                    j=pmt[j-1];
                }else{
                    i++;
//                    j=0;
                }
            }
        }
        if (i == haystack.length() && j != needle.length()) return -1;
        else return i-needle.length();
    }

    public static void main(String[] args) {
        System.out.println(strStr("bacbababaabcbab",
                "abababca"));
    }
}
