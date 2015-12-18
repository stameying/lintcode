import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by stameying on 12/16/15.
 */
public class binary_tree_serialization {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null){
                sb.append("#,");
            }else{
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        String[] array = data.split(",");
        TreeNode[] nodes = new TreeNode[array.length];
        int[] nums = new int[array.length];
        nums[0] = 0;
        for (int i = 0; i < array.length; i++){
            if (i != 0) nums[i] = nums[i-1];
            if (!array[i].equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(array[i]));
                nodes[i] = node;
            }else{
                nodes[i] = null;
                nums[i]++;
            }
        }

        for (int i = 0; i < array.length; i++){
            if (nodes[i] == null) continue;
            nodes[i].left = nodes[2 *(i-nums[i])+1];
            nodes[i].right = nodes[2 *(i-nums[i])+2];
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(4);
        node2.left = node3;
        binary_tree_serialization test = new binary_tree_serialization();
        System.out.println(test.serialize(root));

        test.deserialize("2,1,3,#,#,4,#,#,#,");
    }
}
