package src.first_round;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by stameying on 12/17/15.
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        boolean leftToRight = true;
        currentLevel.push(root);
        ArrayList<Integer> level = new ArrayList<Integer>();
        while (!currentLevel.isEmpty()){
            TreeNode node = currentLevel.pop();
            level.add(node.val);
            if (leftToRight){
                if (node.left != null) nextLevel.push(node.left);
                if (node.right != null) nextLevel.push(node.right);
            }else{
                if (node.right != null) nextLevel.push(node.right);
                if (node.left != null) nextLevel.push(node.left);
            }
            if (currentLevel.isEmpty()){
                leftToRight = !leftToRight;
                currentLevel = nextLevel;
                nextLevel = new Stack<TreeNode>();
                res.add(level);
                level = new ArrayList<Integer>();
            }
        }
        return res;
    }
}
