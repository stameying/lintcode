package src.CodeRound3;

import java.util.Arrays;

/**
 * Created by stameying on 3/18/16.
 */
public class p307 {

    public int[] tree;
    public int[] nums;

    public int lowBit(int k){
        return k&(-k);
    }

    public void updateTree(int idx, int num){
        while (idx < tree.length){
            tree[idx] += num;
            idx += lowBit(idx);
        }
    }

    public int getSum(int idx){
        int sum = 0;
        while (idx > 0){
            sum += tree[idx];
            idx -= lowBit(idx);
        }
        return sum;
    }

    public p307(int[] nums) {
        this.tree = new int[nums.length+1];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++){
            updateTree(i+1,nums[i]);
        }
//        System.out.println(Arrays.toString(this.tree));
    }


    void update(int i, int val) {
        int diff = val - nums[i];
        System.out.println("diff="+diff);
        nums[i] = val;
        updateTree(i+1,diff);
    }

    public int sumRange(int i, int j) {
        return getSum(j+1) - getSum(i);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5};
        p307 tree = new p307(nums);
//        System.out.println(Arrays.toString(tree.tree));
        tree.update(1,2);
        System.out.println(tree.sumRange(1,2));
    }
}
