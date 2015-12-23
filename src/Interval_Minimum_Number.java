import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by stameying on 12/22/15.
 */
public class Interval_Minimum_Number {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A,
                                                ArrayList<Interval> queries) {
        // write your code here
        segmentTreeNode root = buildSegmentTree(A,0,A.length-1);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < queries.size(); i++){
            res.add(queryMin(root,queries.get(i).start,queries.get(i).end));
        }
        return res;
    }

    public int queryMin(segmentTreeNode root, int start, int end){
        if (root == null || root.start > end || root.end < start) return Integer.MAX_VALUE;
        if (root.start == root.end){
            return root.min;
        }
        int mid = root.start + (root.end-root.start)/2;
        if (start > mid){
            return queryMin(root.right,start,end);
        }else if (end <= mid){
            return queryMin(root.left,start,end);
        }else{
            return Math.min(queryMin(root.left,start,mid),queryMin(root.right,mid+1,end));
        }
    }

    public segmentTreeNode buildSegmentTree(int[] A, int left, int right){
        if (left > right) return null;
        segmentTreeNode node = new segmentTreeNode(left,right, Integer.MAX_VALUE);
        if (left == right){
            node.min = A[left];
            return node;
        }
        int mid = left + (right-left)/2;
        segmentTreeNode leftNode = buildSegmentTree(A,left,mid);
        segmentTreeNode rightNode = buildSegmentTree(A,mid+1,right);
        node.min = Math.min(leftNode.min,rightNode.min);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }

    public static void main(String[] args) {
        int[] A = {1,2,7,8,5};
        Interval_Minimum_Number test = new Interval_Minimum_Number();
        segmentTreeNode root = test.buildSegmentTree(A,0,4);
        Queue<segmentTreeNode> queue = new LinkedList<segmentTreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            segmentTreeNode node = queue.poll();
            System.out.print("cur node [" + node.start + "," + node.end + "] = " + node.min + "\n");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

    }
}

class segmentTreeNode{
    int start, end, min;
    segmentTreeNode left, right;
    public segmentTreeNode(int start, int end, int min){
        this.min = min;
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
    }
}
