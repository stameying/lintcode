package EPI.recursion;

import EPI.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/3/16.
 */
public class generateAllBinartTrees {

    public static List<TreeNode> generateAllBinaryTree(int n){
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) return res;
        for (int numOfLeftTreeNodes = 0; numOfLeftTreeNodes < n; numOfLeftTreeNodes++){
            int numOfRightTreeNodes = n-1-numOfLeftTreeNodes;
            List<TreeNode> leftSubtrees = generateAllBinaryTree(numOfLeftTreeNodes);
            List<TreeNode> rightSubtrees = generateAllBinaryTree(numOfRightTreeNodes);
            for (TreeNode left: leftSubtrees){
                for (TreeNode right: rightSubtrees){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
