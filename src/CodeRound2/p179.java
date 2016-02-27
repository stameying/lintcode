package src.CodeRound2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by stameying on 2/26/16.
 */
public class p179 {

    public static String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num: nums){
            list.add(String.valueOf(num));
        }
        Collections.sort(list, StringComparator.cmp);
        StringBuilder builder = new StringBuilder();
        for (int i = list.size()-1; i >= 0; i--){
            builder.append(list.get(i));
        }
        System.out.println(list);
        int i = 0;
        for (; i < builder.length() && builder.charAt(i) == '0'; i++){}
        if (i == builder.length()) return "0";
        return builder.substring(i).toString();
    }

    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String num1, String num2){
            String leftRight = num1+num2;
            String rightLeft = num2+num1;
            return -leftRight.compareTo(rightLeft);
//            int pos1 = 0, pos2 = 0;
//            while (pos1 < num1.length() || pos2 < num2.length()){
//                int digit1 = (pos1 >= num1.length()? num1.charAt(num1.length()-1)-'0':num1.charAt(pos1)-'0');
//                int digit2 = (pos2 >= num2.length()? num2.charAt(num2.length()-1)-'0':num2.charAt(pos2)-'0');
//                if (digit1 > digit2) return 1;
//                else if (digit1 < digit2) return -1;
//                else{
//                    pos1++;
//                    pos2++;
//                }
//            }
//            return num1.length()>num2.length()?1:-1;
        }

        public static final StringComparator cmp = new StringComparator();
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.println(largestNumber(nums));
    }
}
