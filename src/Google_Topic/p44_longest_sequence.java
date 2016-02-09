package Google_Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 2/8/16.
 */
public class p44_longest_sequence {

    /**
     * 这题暂时没做,参见EPI305的题目,感觉差不多
     * */

   public static class TreeNode {List<Edge> edges = new ArrayList<>();}

   public static class Edge{
   		public TreeNode root;
   		public Double length;

   		public Edge(TreeNode root, Double length){
   			this.root = root;
   			this.length = length;
   		}
   }

   public static class HeightAndDiameter{
   	public Double height;
   	public Double diameter;

       public HeightAndDiameter(Double height, Double diameter) {
           this.height = height;
           this.diameter = diameter;
       }
   }

   public static double computeDiameter(TreeNode T){
   		return T != null? computeHeightAndDiameter(T).diameter:0.0;
   }

   public static HeightAndDiameter computeHeightAndDiameter(TreeNode node){
   	double diameter = Double.MIN_VALUE;
   	double[] heights = {0.0, 0.0}; // store the max two heighte
   	for (Edge e: node.edges){
   		HeightAndDiameter heightDiameter = computeHeightAndDiameter(e.root);
   		if (heightDiameter.height + e.length > heights[0]){ // longest path candidate
   			heights[1] = heights[0];
   			heights[0] = heightDiameter.height + e.length;
   		}else if (heightDiameter.height + e.length > heights[1]){
   			heights[1] = heightDiameter.height + e.length;
   		}
   		diameter = Math.max(diameter, heightDiameter.diameter);
   	}
   	return new HeightAndDiameter(heights[0], Math.max(diameter, heights[0]+heights[1]));
   }
   
}
