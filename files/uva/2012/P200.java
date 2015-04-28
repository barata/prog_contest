import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


class Main {
	
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node[] nodes = new Node[256];
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (nodes[c] == null) nodes[c] = new Node(c);
		}
		
		while (!"#".equals(s2)) {
			for (int i = 0; i < s2.length(); i++) {
				char c = s2.charAt(i);
				if (nodes[c] == null) nodes[c] = new Node(c);
			}
			
			for (int p = 0; p < s1.length() && p < s2.length(); p++) {
				char c1 = s1.charAt(p);
				char c2 = s2.charAt(p);
				
				if (c1 != c2) {
					if (!nodes[c2].adj.contains(nodes[c1])) nodes[c2].adj.add(nodes[c1]);
					break;
				}
			}
			
			s1 = s2;
			s2 = br.readLine();
		}
		
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] != null && !nodes[i].visited) {
				DFS(nodes[i]);
			}
		}
		
		
		System.out.println(result);
	}

	private static void DFS(Node node) {
		node.visited = true;
		for (Node adj : node.adj) {
			if (!adj.visited) DFS(adj);
		}
		result.append(node.c);
	}

}

class Node {
	public char c;
	public List<Node> adj;
	public boolean visited;
	
	public Node(char c) {
		this.c = c;
		this.adj = new LinkedList<Node>();
		this.visited = false;
	}
	
	public boolean equals(Object o) {
		return this.c == ((Node) o).c;
	}
	
	public int hashCode() {
		return Character.valueOf(this.c).hashCode();
	}
}