package src.amazon_oa.oa2.second_trial;

import src.first_round.TreeNode;

/**
 * Created by stameying on 2/28/16.
 */
public class p13_minSum {

    public static int minSum(TreeNode root){
        if (root == null) return 0;
        if (root.left != null && root.right == null) return minSum(root.left)+root.val;
        else if (root.left == null && root.right != null) return minSum(root.right)+root.val;
        return Math.min(minSum(root.left),minSum(root.right))+root.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;
		node5.right = node6;

        System.out.println(minSum(node1));
    }
}
