package EPI.binary_tree;

import java.util.Stack;

/**
 * Created by stameying on 1/30/16.
 */
public class findSuccessor {

    public static TreeNodeWithParent findSuccessor(TreeNodeWithParent node){
        if (node.right == null){
            TreeNodeWithParent cur = node.right;
            while (cur.left != null){
                cur = cur.left;
            }
            return cur;
        }else{
            while (node.parent != null && node.parent.right == node) node = node.parent;
            return node.parent;
        }
    }

    public static TreeNode findSuccessor(TreeNode root, TreeNode node){
        if (node.right != null){
            node = node.right;
            while (node.left != null) node = node.left;
            return node;
        }else{
            // find node's parent from root
            TreeNode cur = root;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (!stack.isEmpty() || cur != null){
//                System.out.println("cur="+ (cur!=null?cur.val:-1));
                if (cur != null){
                    if (cur.left == node) return cur;
                    else if (cur.right == node){
                        while (!stack.isEmpty() && stack.peek().right == cur){
                            cur = stack.pop();
                        }
                        return !stack.isEmpty()?stack.pop():null;
                    }else{
                        stack.push(cur);
                        cur = cur.left;
                    }
                }else{
                    cur = stack.pop();
                    cur = cur.right;
                }
            }
            return null;
        }
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

//        System.out.println(A.left == B);
        System.out.println(findSuccessor(A,J).val);
    }
}
