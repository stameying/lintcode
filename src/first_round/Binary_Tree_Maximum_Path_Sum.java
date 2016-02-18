package src.first_round;

/**
 * Created by stameying on 12/16/15.
 */
public class Binary_Tree_Maximum_Path_Sum {

    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root,max);
        return max[0];
    }


    public int calculateSum(TreeNode node, int[] max){
        if (node == null) return 0;
        // max value from left subtree
        int left = calculateSum(node.left, max);
        // max value from right subtree
        int right = calculateSum(node.right, max);

        // option1 left -> cur
        int v1 = left + node.val;
        // option2 right -> cur
        int v2 = right + node.val;
        // option3 cur
        int v3 = node.val;
        // option4 left -> cur -> right
        int v4 = left + node.val + right;
        // max path
        max[0] = Math.max(max[0], Math.max(v1,Math.max(v2,Math.max(v3,v4))));
        // current max path, can't be left -> cur -> right since it won't go up
        int current = Math.max(v1, Math.max(v2,v3));
        return current;
    }
}
