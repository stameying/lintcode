package src.CodeRound3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 3/27/16.
 */
public class p315 {

    public static List<Integer> countSmaller(int[] nums) {

        int[] arr = nums.clone();
        Arrays.sort(arr);

        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            int pos = Arrays.binarySearch(arr,num);
            nums[i] = pos;
        }

//        System.out.println(Arrays.toString(nums));

        IndexTree tree = new IndexTree(arr.length);

        List<Integer> res = new ArrayList<>();
        for (int i = nums.length-1; i >= 0 ; i--){
            System.out.println(Arrays.toString(tree.ids));
            int num = nums[i];
            res.add(0,tree.query(num));
            tree.update(num+1,1);
        }

        System.out.println(Arrays.toString(tree.ids));
        return res;

    }

    private static class IndexTree{
        public int[] ids;

        public IndexTree(int size){
            ids = new int[size];
        }

        public int getLowerBit(int k){
            return k & (-k);
        }

        public int query(int n){
            int res = 0;
            while (n > 0){
                res += ids[n];
                n -=getLowerBit(n);
            }
            return res;
        }

        public void update(int pos, int n){
            while (pos < ids.length){
                ids[pos] += n;
                pos += getLowerBit(pos);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(countSmaller(nums));
    }
}
