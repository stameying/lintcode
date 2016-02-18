package src.first_round;

/**
 * Created by stameying on 12/18/15.
 */
public class SegmentTreeNode {

    public int start, end, max;
    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }
}
