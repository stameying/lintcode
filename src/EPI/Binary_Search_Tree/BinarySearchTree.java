package EPI.Binary_Search_Tree;

/**
 * Created by stameying on 2/1/16.
 */
public class BinarySearchTree {

    public static class TreeNode{
        public Integer val;
        public TreeNode left, right;

        public TreeNode(Integer val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root = null;

    public boolean insert(Integer key){
        if (root == null){
            root = new TreeNode(key,null,null);
        }else{
            TreeNode cur = root;
            TreeNode parent = cur;
            while (cur != null){
                parent = cur;
                int cmp = Integer.compare(key, cur.val);
                if (cmp == 0){
                    return false;
                }else if (cmp == -1){
                    cur = cur.left;
                }else{
                    cur = cur.right;
                }
            }

            if (Integer.compare(key,parent.val) < 0){
                parent.left = new TreeNode(key,null,null);
            }else{
                parent.right = new TreeNode(key,null,null);
            }
        }
        return true;
    }

    public boolean delete(Integer key){
        TreeNode cur = root, parent = null;
        while (cur != null && Integer.compare(cur.val,key) != 0){
            parent = cur;
            cur = Integer.compare(cur.val,key)<0?cur.right:cur.left;
        }
        if (cur == null) return false; //no such element
        TreeNode keyNode = cur;
        if (keyNode.right != null){
            // find the successor
            TreeNode rKeyNode = keyNode.right;
            TreeNode rParent = keyNode;
            while (rKeyNode.left != null){
                rParent = rKeyNode;
                rKeyNode = rKeyNode.left;
            }
            keyNode.val = rKeyNode.val;
            // move links
            if (rParent.left == rKeyNode){
                rParent.left = rKeyNode.right;
            }else{
                rParent.right = rKeyNode.right;
            }
            rKeyNode.right = null;
        }else{
            if (root == keyNode){
                root = keyNode.left;
                keyNode.left = null;
            }else{
                if (parent.left == keyNode){
                    parent.left = keyNode.left;
                }else{
                    parent.right = keyNode.right;
                }
                keyNode.left = null;
            }
        }
        return true;
    }
}
