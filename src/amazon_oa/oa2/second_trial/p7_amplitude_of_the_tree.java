package src.amazon_oa.oa2.second_trial;

/**
 * Created by stameying on 2/27/16.
 */
public class p7_amplitude_of_the_tree {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
            left = null;
            right = null;
        }
    }


    public class TreeAmplitude {
        public int Solution(TreeNode root) {
            if (root == null)	return 0;
            return helper(root, root.val, root.val);
        }

        public int helper(TreeNode node, int min, int max){
            if (node == null) return max-min;
            min = Math.min(min,node.val);
            max = Math.max(max,node.val);
            return Math.max(helper(node.left,min,max),helper(node.right,min,max));
        }

    }
}
