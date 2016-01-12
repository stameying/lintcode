package snapchat;
/**
 * Created by stameying on 1/11/16.
 */
public class construct_binary_tree_from_inandpre_order {


    public TreeNode generate(int[] inorder, int[] preorder, int s1, int e1, int s2, int e2){
        if (s1 > e1 || s2 > e2) return null;
        TreeNode node = new TreeNode(preorder[s2]);
        int pos = findRoot(inorder,node.val, s1, e1);
        int leftSubLen = pos-s1;
        int rightSubLen = e1-pos;
        TreeNode leftNode = generate(inorder,preorder,s1,pos-1,s2+1,s2+leftSubLen);
        TreeNode rightNode = generate(inorder,preorder,pos+1,e1,s2+leftSubLen+1,e2);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }

    public int findRoot(int[] inorder, int val, int s1, int e1){
        for (int i = s1; i <= e1; i++){
            if (inorder[i] == val) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder = {1,4,5,2,7,3};
        int[] preoder = {2,4,1,5,3,7};
        construct_binary_tree_from_inandpre_order test = new construct_binary_tree_from_inandpre_order();
        TreeNode root = test.generate(inorder,preoder,0,inorder.length-1,0,preoder.length-1);
    }


}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
