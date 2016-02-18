package src.first_round;

/**
 * Created by stameying on 12/15/15.
 */
public class subtree {

    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T1 == null && T2 != null) return false;
        if (T1 == null && T2 == null) return true;
        if (T1 != null && T2 == null) return true;
        boolean valid1 = false, valid2 = false;
        if (T1.val == T2.val){
            valid1 = (isSameTree(T1.left, T2.left) && isSameTree(T1.right,T2.right));
        }
        valid2 = isSubtree(T1.left,T2) || isSubtree(T1.right,T2);
        return valid1 || valid2;
    }

    public static boolean isSameTree(TreeNode T1, TreeNode T2){
        if (T1 == null && T2 != null) return false;
        if (T1 == null && T2 == null) return true;
        if (T1 != null && T2 == null) return false; // in this function, this case should be false rather than true
        if (T1.val != T2.val) return false;
        else{
            return isSameTree(T1.left,T2.left) && isSameTree(T1.right,T2.right);
        }
    }

}
