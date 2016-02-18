package src.first_round;

import java.util.Stack;

/**
 * Created by stameying on 12/18/15.
 */
public class Segment_Tree_Modify {

    /**
     *@param root, index, value: The root of segment tree and
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */

    /*
    * Use a stack to keep the visited parent nodes for backtrack
    * */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root == null) return;
        SegmentTreeNode cur = root;
        Stack<SegmentTreeNode> stack = new Stack<SegmentTreeNode>();
        while (cur.left != cur.right){
            stack.push(cur);
            int start = cur.start, end = cur.end;
            int mid = start + (end-start)/2;
            if (index <= mid) cur = cur.left;
            else cur = cur.right;
        }
        // we find the target node
        cur.max = value;
        while (!stack.isEmpty()){
            SegmentTreeNode parent = stack.pop();
            int mid = parent.start + (parent.end-parent.start)/2;
            // cur is parent's right child
            if (cur.start > mid){
                parent.max = Math.max(cur.max, parent.left.max);
                cur = parent;
            }
            // cur is parent's left child
            else{
                parent.max = Math.max(cur.max, parent.right.max);
                cur = parent;
            }
        }
        return;
    }


    /**
     *@param root, index, value: The root of segment tree and
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */

    /*
    * Recursive, more common
    * */
    public void modify2(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root == null) return;
        if (root.left == root.right){
            root.max = value;
            return;
        }
        int mid = root.start+(root.end-root.start)/2;
        if (index > mid){
            modify(root.right,index,value);
        }else{
            modify(root.left,index,value);
        }
        root.max = Math.max(root.left.max,root.right.max);
        return;
    }
}
