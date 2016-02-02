package EPI.Binary_Search_Tree;

import EPI.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/1/16.
 */
public class findLargestKInBST {

    public static List<Integer> findKLargest(TreeNode root, int k){
        List<Integer> res = new ArrayList<>();
        findKLargestHelper(root,k,res);
        return res;
    }

    public static void findKLargestHelper(TreeNode node, int k, List<Integer> res){
        if (node != null && res.size() < k){
            findKLargestHelper(node.right,k,res);
            if (res.size() < k){
                res.add(node.val);
                findKLargestHelper(node.left,k,res);
            }
        }
    }
}
