package src.Google_Topic.Onsite;

/**
 * Created by stameying on 4/5/16.
 */




public class balancedTree {

    private static class HeightNode{
        int height;
        boolean isBalanced;

        public HeightNode(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    public boolean isBalanced(TreeNode root){
        if (root == null) return true;
        return checkBalanced(root).isBalanced;
    }

    public HeightNode checkBalanced(TreeNode node){
        if (node == null) return new HeightNode(-1,true);
        HeightNode leftRes = checkBalanced(node.left);
        if (!leftRes.isBalanced) return leftRes;
        HeightNode rightRes = checkBalanced(node.right);
        if (!rightRes.isBalanced) return rightRes;
        boolean isBalanced = Math.abs(leftRes.height-rightRes.height) <= 1;
        int height = Math.max(leftRes.height,rightRes.height)+1;
        return new HeightNode(height,isBalanced);

    }
}
