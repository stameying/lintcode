package Google_Topic;

/**
 * Created by stameying on 2/17/16.
 */
public class p177_check_complete_tree {
    private class Node{
        public int data;
        public Node left,right;
        public Node(int data){
            this.data = data;
        }
    }

    public static int countNode(Node node){
        if (node == null) return 0;
        return 1+countNode(node.left)+countNode(node.right);
    }

    public boolean isComplete(Node node, int index, int maxNum){
        if (node == null)  return true;
        if (index >= maxNum) return false;
        return isComplete(node.left,2*index+1,maxNum)&&isComplete(node.right,2*index+2,maxNum);
    }

    public static void main(String[] args) {

    }
}
