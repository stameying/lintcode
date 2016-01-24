package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 1/23/16.
 */
public class count_of_smaller_number {

    public int getLowBit(int k){
        return k&(-k);
    }

    public void add(int[] bit, int i , int val){
        System.out.println("here is add process");
        System.out.println("i="+ i + ", val="+val);
        System.out.println(Arrays.toString(bit));
        for (;i < bit.length; i+=getLowBit(i)){
            System.out.println("i = " + i);
            bit[i] += val;
        }
        System.out.println("after add = " + Arrays.toString(bit));
    }

    public int query(int[] bit, int i){
        System.out.println("here is query process");
        int ans = 0;
        System.out.println(Arrays.toString(bit));
        for (; i > 0; i-=getLowBit(i)){
            System.out.println("bit[i] = " + bit[i]);
            ans+=bit[i];
        }
        System.out.println("query ans = " + ans);
        return ans;
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        System.out.println("tmp="+Arrays.toString(tmp));
        for (int i = 0; i < nums.length; i++){
            System.out.println("nums[i] before = " + nums[i]);
            nums[i] = Arrays.binarySearch(tmp,nums[i]);
            System.out.println("nums[i] after = " + nums[i]);
        }
        int[] bit = new int[nums.length];
        Integer[] ans = new Integer[nums.length];
        for (int i = nums.length-1; i >= 0; i--){
            ans[i] = query(bit,nums[i]);
            add(bit,nums[i]+1,1);
            System.out.println("asn = " + Arrays.toString(ans));
        }
        return Arrays.asList(ans);
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        count_of_smaller_number test = new count_of_smaller_number();
        List<Integer> res = test.countSmaller(nums);
        for (int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
