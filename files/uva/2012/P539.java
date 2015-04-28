import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tks.nextToken());
		int m = Integer.parseInt(tks.nextToken());
		
		while (n != 0 || m != 0) {
			Node[] nodes = new Node[n];
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new Node(i);
			}
			
			for (int i = 0; i < m; i++) {
				tks = new StringTokenizer(br.readLine());
				int src = Integer.parseInt(tks.nextToken());
				int dst = Integer.parseInt(tks.nextToken());
				
				nodes[src].adj.add(nodes[dst]);
				nodes[dst].adj.add(nodes[src]);
			}
			
			int max = 0;
			boolean[][] edges = new boolean[n][n];
			
			for (int i = 0; i < nodes.length; i++) {
				max = Math.max(max, longestPath(nodes[i], edges));
			}
			
			System.out.println(max);
			
			
			tks = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tks.nextToken());
			m = Integer.parseInt(tks.nextToken());
		}
	}

	private static int longestPath(Node node, boolean[][] edges) {
		int max = 0;
		
		for (Node adj : node.adj) {
			if (!edges[node.id][adj.id]) {
				edges[node.id][adj.id] = true;
				edges[adj.id][node.id] = true;
				max = Math.max(max, longestPath(adj, edges) + 1);
				edges[node.id][adj.id] = false;
				edges[adj.id][node.id] = false;
			}
		}
		
		return max;
	}

}

class Node {
	public int id;
	public List<Node> adj;
	
	public Node(int id) {
		this.id = id;
		this.adj = new LinkedList<Node>();
	}
}