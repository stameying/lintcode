package EPI.array;

import java.util.*;

/**
 * Created by stameying on 1/29/16.
 */
public class random_sampling {

    /**
    * Generate a subset of K numbers from an array of n numbers randomly
    * */
    public static void sampling(List<Integer> nums, int k){
        Random gen = new Random();
        for (int i = 0; i < k; i++){
            int temp = i+gen.nextInt(nums.size()-i);
            System.out.println("i="+i+";ran="+temp);
            Collections.swap(nums,i,temp);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        sampling(list,3);
        System.out.println(list);
    }
}
