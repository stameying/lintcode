import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/8/16.
 */
public class Unique_Binary_Search_Trees_II {

    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        return buildTree(1,n);
    }

    public List<TreeNode> buildTree(int from, int to){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (from > to){
            list.add(null);
            return list;
        }
        for (int i = from; i <= to; i++){
            List<TreeNode> left = buildTree(from, i-1);
            List<TreeNode> right = buildTree(i+1,to);
            for (TreeNode leftSubnode : left){
                for (TreeNode rightSubnode: right){
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftSubnode;
                    cur.right = rightSubnode;
                    list.add(cur);
                }
            }
        }
        return list;
    }

}
