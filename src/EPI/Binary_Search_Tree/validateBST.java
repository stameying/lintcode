package EPI.Binary_Search_Tree;

import EPI.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by stameying on 2/1/16.
 */
public class validateBST {

    private static class QueueEntry{
        public Integer lowerBound, upperBound;
        public TreeNode treeNode;

        public QueueEntry(Integer lowerBound, Integer upperBound, TreeNode treeNode) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.treeNode = treeNode;
        }
    }

    public static boolean validateBST(TreeNode root){
        if (root == null) return true;
        Queue<QueueEntry> queue = new LinkedList<>();
        queue.offer(new QueueEntry(Integer.MIN_VALUE,Integer.MAX_VALUE,root));
        while (!queue.isEmpty()){
            QueueEntry cur = queue.poll();
            if (cur.treeNode.val < cur.lowerBound || cur.treeNode.val > cur.upperBound) return false;
            if (cur.treeNode.left != null){
                queue.offer(new QueueEntry(cur.lowerBound,cur.treeNode.val,cur.treeNode.left));
            }
            if (cur.treeNode.right != null){
                queue.offer(new QueueEntry(cur.treeNode.val,cur.upperBound,cur.treeNode.right));
            }
        }
        return true;
    }
}
