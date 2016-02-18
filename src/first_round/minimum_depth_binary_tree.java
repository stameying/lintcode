package src.first_round;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by stameying on 12/13/15.
 */
public class minimum_depth_binary_tree {
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) return 0;
        if ( root.left == null && root.right == null) return 1;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (root.left != null){
            left = minDepth(root.left);
        }
        if (root.right != null){
            right = minDepth(root.right);
        }
        return Math.min(left,right)+1;
    }

    public int minDepth2(TreeNode root) {
        // write your code here
        // bfs
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int depth = 1, curLevel = 1;
        queue.add(root);
        while(!queue.isEmpty()){
            for (int i = 0; i < curLevel; i++){
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) return depth;
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            curLevel = queue.size();
            depth++;
        }
        return -1;
    }
}
