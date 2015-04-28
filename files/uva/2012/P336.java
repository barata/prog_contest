import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numCase = 0;
		int nc = sc.nextInt();
		
		while (nc != 0) {
			Map<String, Node> nodes = new HashMap<String, Node>();
			
			for (int i = 0; i < nc; i++) {
				String id1 = sc.next();
				String id2 = sc.next();
				if (!nodes.containsKey(id1)) nodes.put(id1, new Node(id1));
				if (!nodes.containsKey(id2)) nodes.put(id2, new Node(id2));
				Node node1 = nodes.get(id1);
				Node node2 = nodes.get(id2);
				node1.adj.add(node2);
				node2.adj.add(node1);
			}
			
			String start = sc.next();
			int ttl = sc.nextInt();
			
			while (!"0".equals(start) || ttl != 0) {
				
				Set<Node> reachable = new HashSet<Node>();
				reachable.add(nodes.get(start));
				int currentTTL = ttl;
				
				while (currentTTL-- > 0) {
					Set<Node> newReachable = new HashSet<Node>();
					
					for (Node node : reachable) {
						newReachable.addAll(node.adj);
					}
					
					reachable.addAll(newReachable);
				}
				
				System.out.println("Case " + ++numCase + ": " + (nodes.size() - reachable.size()) + " nodes not reachable from node " + start + " with TTL = " + ttl + ".");
				
				
				start = sc.next();
				ttl = sc.nextInt();
			}
			
			nc = sc.nextInt();
		}
	}

}

class Node {
	public String id;
	public List<Node> adj;
	
	public Node(String id) {
		this.id = id;
		this.adj = new LinkedList<Node>();
	}
	
	public boolean equals(Object o) {
		return ((Node) o).id.equals(this.id);
	}
	
	public int hashCode() {
		return this.id.hashCode();
	}
}