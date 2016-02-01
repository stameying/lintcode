package EPI.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/31/16.
 */
public class listofLeaves {

    public static List<Integer> listOfLeaves(TreeNode root){
        List<Integer> list = new ArrayList<>();
        addLeaves(root,list);
        return list;
    }

    public static void addLeaves(TreeNode node, List<Integer> res){
        if (node != null){
            if (node.left == null && node.right == null) res.add(node.val);
            else{
                addLeaves(node.left,res);
                addLeaves(node.right,res);
            }
        }
    }
}
