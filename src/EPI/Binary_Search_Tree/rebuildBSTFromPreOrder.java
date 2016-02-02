package EPI.Binary_Search_Tree;

import EPI.binary_tree.TreeNode;

import java.util.List;

/**
 * Created by stameying on 2/1/16.
 */
public class rebuildBSTFromPreOrder {

    public static TreeNode rebuildTree(List<Integer> preorder){
        return rebuildTreeFromPreOrder(preorder,0,preorder.size());
    }

    public static TreeNode rebuildTreeFromPreOrder(List<Integer> preorder, int start, int end){
        if (start >= end) return null;
        int transitionPoint = start+1;
        while (transitionPoint < end && Integer.compare(preorder.get(transitionPoint),preorder.get(start))<0) ++transitionPoint;
        TreeNode node = new TreeNode(preorder.get(start));
        node.left = rebuildTreeFromPreOrder(preorder,start+1,transitionPoint);
        node.right = rebuildTreeFromPreOrder(preorder, transitionPoint,end);
        return node;
    }

    public static void main(String[] args) {

    }
}
