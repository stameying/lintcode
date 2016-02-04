package EPI.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/3/16.
 */
public class computeDiamter {

    public static class TreeNode{
        List<Edge> edges = new ArrayList<>();
    }

    private static class Edge{
        public TreeNode root;
        public Double length;

        public Edge(TreeNode root, Double length) {
            this.root = root;
            this.length = length;
        }
    }

    private static class HeightAndDiameter{
        public Double height;
        public Double diameter;

        public HeightAndDiameter(Double height, Double diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static double computerDiameter(TreeNode root){
        return root != null? computeHeightAndDiameter(root).diameter:0.0;
    }

    private static HeightAndDiameter computeHeightAndDiameter(TreeNode node){
        double diamter = Double.MIN_VALUE;
        double[] height = {0.0,0.0};
        for (Edge e: node.edges){
            HeightAndDiameter heightDiameter = computeHeightAndDiameter(e.root);
            if (heightDiameter.height + e.length > height[0]){
                height[1] = height[0];
                height[0] = heightDiameter.height + e.length;
            }else if (heightDiameter.height + e.length > height[1]){
                height[1] = heightDiameter.height + e.length;
            }
            diamter = Math.max(diamter, heightDiameter.diameter);
        }
        return new HeightAndDiameter(height[0], Math.max(diamter, height[0]+height[1]));
    }
}
