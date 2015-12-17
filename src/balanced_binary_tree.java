/**
 * Created by stameying on 12/16/15.
 */
public class balanced_binary_tree {
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        return (isBalanced(root.left) && isBalanced(root.right));
    }

    public int getHeight(TreeNode node){
        if (node == null) return 0;
        return (Math.max(getHeight(node.left),getHeight(node.right))+1);
    }
}
