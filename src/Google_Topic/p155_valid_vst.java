package Google_Topic;

import EPI.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by stameying on 2/16/16.
 */
public class p155_valid_vst {

    private static class QueueEntry{
        public TreeNode node;
        public Integer lowerBound, upperBound;

        public QueueEntry(TreeNode node, Integer lowerBound, Integer upperBound) {
            this.node = node;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

    public static boolean isValidBST(TreeNode root){
        Queue<QueueEntry> queue = new LinkedList<>();
        queue.offer(new QueueEntry(root,Integer.MIN_VALUE, Integer.MAX_VALUE));
        QueueEntry headEntry;
        while ((headEntry=queue.poll()) != null){
            if (headEntry.node != null){
                if (headEntry.node.val < headEntry.lowerBound || headEntry.node.val > headEntry.upperBound) return false;
                queue.offer(new QueueEntry(headEntry.node.left, headEntry.lowerBound, headEntry.node.val));
                queue.offer(new QueueEntry(headEntry.node.right, headEntry.node.val, headEntry.upperBound));
            }
        }
        return true;
    }
}
