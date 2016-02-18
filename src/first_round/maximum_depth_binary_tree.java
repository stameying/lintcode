package src.first_round;

/**
 * Created by stameying on 12/11/15.
 */
public class maximum_depth_binary_tree {

    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) return 0;
        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }


}
