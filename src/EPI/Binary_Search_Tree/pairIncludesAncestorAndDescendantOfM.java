package EPI.Binary_Search_Tree;

import EPI.binary_tree.TreeNode;

/**
 * Created by stameying on 2/2/16.
 */
public class pairIncludesAncestorAndDescendantOfM {

    public static boolean pairOfAncAndDesofM(TreeNode possibleAncOrDesc0, TreeNode possibleAncOrDesc1, TreeNode middle){
        TreeNode search0 = possibleAncOrDesc0, search1 = possibleAncOrDesc1;
        while (search0 != possibleAncOrDesc0 && search0 != middle && search1 != possibleAncOrDesc1 && search1 != middle && (search0 != null || search1 != null)){
            if (search0 != null){
                search0 = search0.val > middle.val? search0.left:search0.right;
            }
            if (search1 != null){
                search1 = search1.val > middle.val? search0.left:search1.right;
            }
        }

        if (search0 == possibleAncOrDesc1 || search1 == possibleAncOrDesc0) return false;

        return search0 == middle? searchTarget(middle, possibleAncOrDesc1): searchTarget(middle, possibleAncOrDesc0);
    }

    private static boolean searchTarget(TreeNode from, TreeNode target){
        while (from != null && from.val != target.val){
            from = from.val > target.val? from.left:from.right;
        }
        return from == target;
    }


}
