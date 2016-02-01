package EPI.binary_tree;

import java.util.List;

/**
 * Created by stameying on 1/31/16.
 */
public class reconstructPreorder {
    private static Integer subTreeIdx;
    public TreeNode reconstructPreorder(List<Integer> list){
        subTreeIdx = 0;
        return reconstructPreorderSubtree(list);
    }

    public TreeNode reconstructPreorderSubtree(List<Integer> list){
        Integer subtreeKey = list.get(subTreeIdx);
        ++subTreeIdx;
        if (subtreeKey == null) return null;
        TreeNode left = reconstructPreorderSubtree(list);
        TreeNode right = reconstructPreorderSubtree(list);
        TreeNode root =  new TreeNode(subtreeKey);
        root.left = left;
        root.right = right;
        return root;
    }
}
