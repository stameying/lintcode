package EPI.stack_and_queue;

import leetcode.google.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by stameying on 1/28/16.
 */
public class bfs {

    public static List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> res= new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node1);
        queue.offer(null);
        System.out.println(queue.size());
    }
}
