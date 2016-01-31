package EPI.binary_tree;

/**
 * Created by stameying on 1/30/16.
 */
public class TreeNodeWithParent {
    public int val;
    TreeNodeWithParent left,right,parent;
    public TreeNodeWithParent(int val, TreeNodeWithParent parent){
        this.val = val;
        this.parent = parent;
    }
}
