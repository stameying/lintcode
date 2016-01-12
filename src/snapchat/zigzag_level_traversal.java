package snapchat;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by stameying on 1/11/16.
 */
public class zigzag_level_traversal {

    public List<List<Integer>> zigzag_level_traversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<TreeNode> curLevel = new ArrayList<TreeNode>();
        curLevel.add(root);
        boolean reverse = false;
        while (curLevel.size() != 0){
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            List<Integer> values = new ArrayList<Integer>();
            for (int i = 0; i < curLevel.size(); i++){
                if (!reverse){
                    values.add(curLevel.get(i).val);
                }else{
                    values.add(0,curLevel.get(i).val);
                }
                if (curLevel.get(i).left != null) nextLevel.add(curLevel.get(i).left);
                if (curLevel.get(i).right != null) nextLevel.add(curLevel.get(i).right);
            }
            res.add(values);
            curLevel = new ArrayList<TreeNode>(nextLevel);
            reverse = !reverse;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

