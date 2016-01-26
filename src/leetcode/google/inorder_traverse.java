package leetcode.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by stameying on 1/24/16.
 */
public class inorder_traverse {

    /*
    * recursive
    * */
    public static List<Integer> inorderTravel(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    /*
    * Iterative
    * */
    public static List<Integer> inorderTravel2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode node = stack.pop();
                res.add(node.val);
                cur = cur.right;
            }
        }
        return res;
    }
    public static void inorder(TreeNode node, List<Integer> res){
        if (node == null) return;
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }



    public static void main(String[] args) {

    }
}
