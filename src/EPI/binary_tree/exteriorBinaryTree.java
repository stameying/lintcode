package EPI.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/31/16.
 */
public class exteriorBinaryTree {

    public static List<Integer> exteriorBT(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root != null){
            res.add(root.val);
            res.addAll(leftPathAndLeaves(root.left, true));
            res.addAll(rightPathAndLeaves(root.right, true));
        }
        return res;
    }

    public static List<Integer> leftPathAndLeaves(TreeNode node, Boolean isBound){
        List<Integer> res = new ArrayList<>();
        if (node != null){
            if (isBound || isLeaf(node)){
                res.add(node.val);
            }
            res.addAll(leftPathAndLeaves(node.left,isBound));
            res.addAll(rightPathAndLeaves(node.right,isBound&&node.left==null));
        }
        return res;
    }

    public static List<Integer> rightPathAndLeaves(TreeNode node, Boolean isBound){
        List<Integer> res = new ArrayList<>();
        if (node != null){
            res.addAll(leftPathAndLeaves(node.left,isBound&&node.right==null));
            res.addAll(rightPathAndLeaves(node.right,isBound));
            if (isBound || isLeaf(node)){
                res.add(node.val);
            }
        }
        return res;
    }

    public static boolean isLeaf(TreeNode node){
        return node!=null&&node.left==null&&node.right==null;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(314);
        TreeNode B = new TreeNode(6);
        TreeNode C = new TreeNode(271);
        TreeNode D = new TreeNode(28);
        TreeNode E = new TreeNode(0);
        TreeNode F = new TreeNode(561);
        TreeNode G = new TreeNode(3);
        TreeNode H = new TreeNode(17);
        TreeNode I = new TreeNode(6);
        TreeNode J = new TreeNode(2);
        TreeNode K = new TreeNode(1);
        TreeNode L = new TreeNode(401);
        TreeNode M = new TreeNode(641);
        TreeNode N = new TreeNode(257);
        TreeNode O = new TreeNode(271);
        TreeNode P = new TreeNode(28);

        A.left = B;
        A.right = I;
        B.left = C;
        B.right = F;
        C.left = D;
        C.right = E;
        F.right = G;
        G.left = H;
        I.left = J;
        I.right = O;
        J.right = K;
        K.left = L;
        K.right = N;
        L.right = M;
        O.right = P;

        System.out.println(exteriorBT(A));
    }
}
