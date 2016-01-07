import java.util.Arrays;

/**
 * Created by stameying on 1/6/16.
 */
public class sort_letters {

    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if (chars.length <= 1) return;
        int i = 0, j = chars.length-1;
        while ( i != j){
            while (i < j && chars[j] <= 'Z' && chars[j] >= 'A') j--;
            while (i < j && chars[i] <= 'z' && chars[i] >= 'a') i++;
            System.out.println("i="+i+",j="+j);
            if (i < j){
                swap(chars,i,j);
            }
        }
    }

    public void swap(char[] chars, int left, int right){
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

    public static void main(String[] args) {
        String str = "abAcD";
        char[] arr = str.toCharArray();
        sort_letters test = new sort_letters();
        test.sortLetters(arr);
        System.out.println(Arrays.toString(arr));
    }
}
