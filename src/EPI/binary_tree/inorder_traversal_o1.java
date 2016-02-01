package EPI.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/31/16.
 */
public class inorder_traversal_o1 {

    public static List<Integer> inorder_traversal_o1(TreeNodeWithParent root){
        List<Integer> res = new ArrayList<>();
        TreeNodeWithParent cur = root, prev = null;
        while (cur != null){
            TreeNodeWithParent next = null;
            if (cur.parent == prev){
                // moving down
                if (cur.left != null){
                    next = cur.left;
                }else{
                    res.add(cur.val);
                    next = (cur.right != null)? cur.right:cur.parent;
                }
            }else if (cur.left == prev){
                res.add(cur.val);
                next = (cur.right != null)? cur.right:cur.parent;
            }else{
                next = cur.parent;
            }
            prev = cur;
            cur = next;
        }
        return res;
    }
}
