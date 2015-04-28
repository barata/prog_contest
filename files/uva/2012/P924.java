import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int e = sc.nextInt();
		Node[] nodes = new Node[e];
		
		for (int i = 0; i < e; i++) {
			int n = sc.nextInt();
			if (nodes[i] == null) nodes[i] = new Node();
			
			for (int j = 0; j < n; j++) {
				int adj = sc.nextInt();
				if (nodes[adj] == null) nodes[adj] = new Node();
				nodes[i].adj.add(nodes[adj]);
			}
		}
		
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(nodes[n]);
			int firstDay = 0;
			int currentDay = 1;
			int maxBoomSize = 0;
			
			for (int j = 0; j < nodes.length; j++) {
				nodes[j].visited = false;
			}
			nodes[n].visited = true;
			
			while (!list.isEmpty()) {
				LinkedList<Node> newList = new LinkedList<Node>();

				for (Node node : list) {
					for (Node adj : node.adj) {
						if (!adj.visited) {
							adj.visited = true;
							newList.add(adj);
						}
					}
				}

				if (newList.size() > maxBoomSize) {
					maxBoomSize = newList.size();
					firstDay = currentDay;
				}
				list = newList;
				currentDay++;
			}
			
			if (maxBoomSize == 0) System.out.println("0");
			else System.out.println(maxBoomSize + " " + firstDay);
		}
	}
}

class Node {
	public List<Node> adj;
	public boolean visited;
	
	public Node() {
		this.adj = new LinkedList<Node>();
		visited = false;
	}
}