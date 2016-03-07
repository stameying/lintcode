package src.CodeRound2;

/**
 * Created by stameying on 3/4/16.
 */
public class segmentTree {


    public class SegmentTreeNode {
          public int start, end;
          public SegmentTreeNode left, right;
          public SegmentTreeNode(int start, int end) {
              this.start = start;
              this.end = end;
              this.left = this.right = null;
          }
    }

    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if (start > end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        if (start == end) return root;
        int mid = start + (end-start)/2;
        SegmentTreeNode left = build(start,mid);
        SegmentTreeNode right = build(mid+1,end);
        root.left = left;
        root.right = right;
        return root;
    }


}
