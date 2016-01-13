package leetcode.google;
/**
 * Created by stameying on 1/12/16.
 */
public class closet_bst {
    public int closestValue(TreeNode root, double target) {
        int closet = 0;
        double distance = Double.MAX_VALUE;
        TreeNode cur = root;
        while ( cur != null){
            double temp = Math.abs(cur.val-target);
            if (Math.abs(cur.val-target) < distance){
                distance = temp;
                closet = cur.val;
            }
            if (cur.val < target){
                cur = cur.right;
            }else if (cur.val > target){
                cur = cur.left;
            }else{
                // same
                return (int)target;
            }
        }
        return closet;
    }
}
