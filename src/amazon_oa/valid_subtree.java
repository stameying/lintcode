package src.amazon_oa;

import src.first_round.TreeNode;

/**
 * Created by stameying on 2/25/16.
 */
public class valid_subtree {


    /**
     * check if t2 is a subtree of t1
     * */
    public static boolean is_subtree(TreeNode t1, TreeNode t2){
        if (t2 == null) return true;
        if (t1 == null) return false;
        return isSameTree(t1,t2) || is_subtree(t1.left,t2) || is_subtree(t1.right,t2);
    }

    public static boolean isSameTree(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        else if (t1 == null || t2 == null) return false;
        else if (t1.val != t2.val) return false;
        else return isSameTree(t1.left,t2.left)&&isSameTree(t1.right,t2.right);
    }
}
