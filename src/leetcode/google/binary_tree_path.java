package leetcode.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/11/16.
 */
public class binary_tree_path {
    class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public class Binary_Tree_Path{
        public List<String> binaryTreePaths(TreeNode root){
            List<String> res = new ArrayList<String>();
            List<Integer> path = new ArrayList<Integer>();
            dfs(root,path,res);
            return res;
        }

        public void dfs(TreeNode node, List<Integer> path, List<String> res){
            if (node == null) return;
            path.add(node.val);
            if (node.left == null && node.right == null){
                // reach a leaf node
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < path.size(); i++){
                    builder.append(path.get(i));
                    if (i != path.size()-1) builder.append("->");
                }
                res.add(builder.toString());
                path.remove(path.size()-1);
                return;
            }
            if (node.left != null) dfs(node.left,path,res);
            if (node.right != null) dfs(node.right,path,res);
            path.remove(path.size()-1);
        }
    }
}
