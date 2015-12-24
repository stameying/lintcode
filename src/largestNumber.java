import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by stameying on 12/23/15.
 */
public class largestNumber {

    public String largestNumber(int[] num) {
        // write your code here
        String[] strList = new String[num.length];
        for (int i = 0; i < num.length; i++){
            strList[i] = num[i] + "";
        }
        Arrays.sort(strList,new string_comparator1());
        System.out.println("array is " + Arrays.toString(strList));
        String res = "";
        for (int i = strList.length-1; i>= 0; i--){
            res += strList[i];
        }
        boolean leadingZero = true;
        int index = 0;
        while (leadingZero && index < res.length()-1 && res.charAt(index) == '0') index++;
        if (index > 0) res = res.substring(index);
        return res;
    }

    public String largestNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new NumbersComparator());
        System.out.println("array is " + Arrays.toString(strs));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result.substring(index);
    }

    public static void main(String[] args) {
        int[] input = {12,121, 830,8308};
        largestNumber test = new largestNumber();
        test.largestNumber2(input);
    }
}


class NumbersComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
    }
}
