import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by stameying on 1/3/16.
 */
public class reverse_sort {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(3);
        nums.add(3);
        nums.add(2);
        nums.add(4);
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1*(Integer.compare(o1,o2));
            }
        });
        Integer[] arr = nums.toArray(new Integer[nums.size()]);
        System.out.println(Arrays.toString(arr));
    }
}
