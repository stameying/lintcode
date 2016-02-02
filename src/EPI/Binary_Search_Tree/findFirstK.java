package EPI.Binary_Search_Tree;

import EPI.binary_tree.TreeNode;

/**
 * Created by stameying on 2/1/16.
 */
public class findFirstK {

    public static TreeNode findFirstK(TreeNode root, int k){
        if (root == null) return null;
        else if (root.val == k){
            TreeNode node = findFirstK(root.left,k);
            return node == null?root:node;
        }
        return findFirstK(root.val<k?root.right:root.left,k);
    }

    public static TreeNode findFirstKIter(TreeNode root, int k){
        TreeNode firstSoFar = null, cur = root;
        while (cur != null){
            if (cur.val < k){
                cur = cur.right;
            }else if (cur.val > k){
                cur = cur.left;
            }else{
                firstSoFar = cur;
                cur = cur.left;
            }
        }
        return firstSoFar;
    }
}
