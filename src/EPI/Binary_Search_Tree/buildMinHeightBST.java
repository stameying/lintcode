package EPI.Binary_Search_Tree;

import EPI.binary_tree.TreeNode;

import java.util.List;

/**
 * Created by stameying on 2/1/16.
 */
public class buildMinHeightBST {

    public static TreeNode buildTree(List<Integer> list){
        return buildTreeMinHeight(list,0,list.size()-1);
    }

    public static TreeNode buildTreeMinHeight(List<Integer> list, int left, int right){
        if (left > right) return null;
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTreeMinHeight(list,left,mid-1);
        root.right= buildTreeMinHeight(list,mid+1,right);
        return root;
    }
}
