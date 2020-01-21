import java.util.*;

public class GraphNode {
	private String val;
	private HashSet<GraphNode> neighbors;
	
	GraphNode(String val) {
		this.val = val;
		neighbors = new HashSet<GraphNode>();
	}
	
	public void setNeighbor(GraphNode node) {
		neighbors.add(node);
	}
	
	public void removeNeighbor(GraphNode node) {
		neighbors.remove(node);
	}
	
	public String getVal() {
		return val;
	}
	
	public HashSet<GraphNode> getNeighbors() {
		return neighbors;
	}
	
	public void setVal(String val) {
		this.val = val;
	}
	
}
