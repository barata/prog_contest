import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(tks.nextToken());
		int c = Integer.parseInt(tks.nextToken());
		
		while (s != 0 || c != 0) {
			
			Map<String, Node> grafo = new HashMap<String, Node>();
			Map<String, Map<String, Integer>> costs = new HashMap<String, Map<String,Integer>>();
			
			for (int i = 0; i < s; i++) {
				String name = br.readLine();
				grafo.put(name, new Node(name));
			}
			
			for (int i = 0; i < c; i++) {
				tks = new StringTokenizer(br.readLine());
				String name1 = tks.nextToken();
				String name2 = tks.nextToken();
				int cost = Integer.parseInt(tks.nextToken());
				
				Node node1 = grafo.get(name1);
				Node node2 = grafo.get(name2);
				node1.adj.add(node2);
				node2.adj.add(node1);
				if (!costs.containsKey(name1)) costs.put(name1, new HashMap<String, Integer>());
				if (!costs.containsKey(name2)) costs.put(name2, new HashMap<String, Integer>());
				costs.get(name1).put(name2, cost);
				costs.get(name2).put(name1, cost);
			}
			
			long mst = MST(grafo, br.readLine(), costs);
			System.out.println(mst < 0 ? "Impossible" : mst);
			
			tks = new StringTokenizer(br.readLine());
			s = Integer.parseInt(tks.nextToken());
			c = Integer.parseInt(tks.nextToken());
		}
	}

	static long MST(Map<String, Node> grafo, String start, Map<String, Map<String, Integer>> costs) {
		long soma = 0;
		int count = grafo.size();
		
		Node no = grafo.get(start);
		no.d = 0;
		
		while (!grafo.isEmpty()) {
			no = extractMin(grafo);
			if (no == null) {
				break;
			}
			count--;
			soma += no.d;
			
			for (Node adj : no.adj) {
				if (adj.d > costs.get(no.name).get(adj.name)) {
					adj.d = costs.get(no.name).get(adj.name);
				}
			}
		}
		
		return count == 0 ? soma : -1;
	}
	
	static Node extractMin(Map<String, Node> grafo) {
		Node min = new Node("");
		min.d = Integer.MAX_VALUE;
		
		for (Node node : grafo.values()) {
			if (node.d < min.d) {
				min = node;
			}
		}
		
		return grafo.remove(min);
	}
	
}

class Node {
	public String name;
	public List<Node> adj;
	public int d;
	
	public Node(String name) {
		this.name = name;
		this.adj = new LinkedList<Node>();
		this.d = Integer.MAX_VALUE;
	}
	
	public int hashCode() {
		return this.name.hashCode();
	}
	
	public boolean equals(Object o) {
		return ((String) o).equals(this.name);
	}
	
}