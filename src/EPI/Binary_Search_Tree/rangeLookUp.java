package EPI.Binary_Search_Tree;

import EPI.binary_tree.TreeNode;
import leetcode.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/2/16.
 */
public class rangeLookUp {

    public static List<Integer> loopupRange(TreeNode root, Interval interval){
        List<Integer> res = new ArrayList<>();
        helper(root, interval, res);
        return res;
    }

    public static void helper(TreeNode node, Interval interval, List<Integer> res){
        if (node == null) return;
        if (interval.start <= node.val && node.val <= interval.end){
            helper(node.left,interval,res);
            res.add(node.val);
            helper(node.right,interval,res);
        }else if (interval.start > node.val){
            helper(node.right,interval,res);
        }else{
            helper(node.left,interval,res);
        }
    }
}
