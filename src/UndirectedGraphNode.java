import java.util.ArrayList;

/**
 * Created by stameying on 12/17/15.
 */
public class UndirectedGraphNode {
             int label;
             ArrayList<UndirectedGraphNode> neighbors;
             UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>();
             }
}
