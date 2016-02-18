package src.first_round;

import java.util.ArrayList;

/**
 * Created by stameying on 1/4/16.
 */
public class DirectedGraphNode {

    int label;
    ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
