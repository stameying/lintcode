package EPI.binary_tree;

/**
 * Created by stameying on 1/30/16.
 */
public class root_to_leaf_sum {

    public static int sumRootToLeaf(TreeNode root){
        return sumRootToleafHelper(root,0);
    }

    public static int sumRootToleafHelper(TreeNode node, int patialSum){
        if (node == null) return 0;
        patialSum = patialSum*2 + node.val;
        if (node.left == null && node.right == null) return patialSum;
        return sumRootToleafHelper(node.left,patialSum)+sumRootToleafHelper(node.right,patialSum);
    }
}
