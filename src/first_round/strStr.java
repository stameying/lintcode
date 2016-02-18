package src.first_round;

/**
 * Created by stameying on 12/15/15.
 */
public class strStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        int[] table = buildPMT(target);
        char[] sourceArr = source.toCharArray();
        char[] targetArr = target.toCharArray();
        int i = 0, j = 0;
        while (i < sourceArr.length && j < targetArr.length){
            if (sourceArr[i] == targetArr[j]){
                i++;
                j++;
            }else{
                if ( j == 0){
                    i++;
                }else{
                    j = table[j-1];
                }
            }
        }
        if (j == targetArr.length){
            return i-j;
        }
        return -1;
    }

    public int[] buildPMT(String str){
        char[] arr = str.toCharArray();
        int i = 1, j = 0;
        int[] table = new int[arr.length];
        while ( i < arr.length){
            if (arr[i] != arr[j]){
                if (j == 0){
                    table[i] = 0;
                    i++;
                }else{
                    j = table[j-1];
                }
            }
            else{
                table[i] = j + 1;
                i++;
                j++;
            }
        }
        return table;
    }

    public void printPMT(char[] pattern, int[] pmt){
        System.out.println("Patial Matching Table:");
        for (int i = 0; i < pattern.length; i++){
            System.out.print(pattern[i] + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < pmt.length; i++){
            System.out.print(pmt[i] + " ");
        }
    }

    public static void main(String[] args) {

        String textstr = "mississippi";
        String str = "aacecaaa";
        char[] pattern = str.toCharArray();
        strStr algorithm = new strStr();
        int[] table = algorithm.buildPMT(str);
        algorithm.printPMT(pattern, table);
        System.out.println("\n");
        System.out.println(algorithm.strStr(textstr, str));

    }
}
