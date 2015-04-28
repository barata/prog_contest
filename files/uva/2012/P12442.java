import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	
	static int begin;
	static int end;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int g = 1; g <= t; g++) {
			int n = Integer.parseInt(br.readLine());
			
			begin = end = -1;
			max = 0;
			Node[] nodes = new Node[n + 1];
			
			for (int i = 1; i <= n; i++) {
				if (nodes[i] == null) nodes[i] = new Node(i);
				
				StringTokenizer tks = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(tks.nextToken());
				int v = Integer.parseInt(tks.nextToken());
				
				if (nodes[u] == null) nodes[u] = new Node(u);
				if (nodes[v] == null) nodes[v] = new Node(v);
				
				nodes[u].next = nodes[v];
			}
			
			for (int i = 1; i <= n; i++) {
				if (nodes[i].reachable < 0) {
					DFS(nodes[i], 1);
				}
			}

			for (int i = 1; i <= n; i++) {
				if (nodes[i].reachable == max) {
					System.out.println("Case " + g + ": " + i);
					break;
				}
			}
		}
	}

	private static void DFS(Node node, int depth) {
		if (node.cor == Node.CINZA) {
			begin = node.reachable;
			end = depth;
			return;
		} else if (node.cor == Node.PRETO) {
			begin = end = -1;
			return;
		}
		
		node.reachable = depth;
		node.cor = Node.CINZA;
		DFS(node.next, depth + 1);
		node.cor = Node.PRETO;
		if (node.reachable >= begin && node.reachable < end) node.reachable = end - begin;
		else node.reachable = node.next.reachable + 1;
		max = Math.max(max, node.reachable);
	}

}

class Node {
	public static final int BRANCO = 0, CINZA = -1, PRETO = -2;
	
	public int id;
	public Node next;
	public int reachable;
	public int cor;
	
	public Node(int id) {
		this.id = id;
		this.next = null;
		this.reachable = -1;
		this.cor = BRANCO;
	}
}