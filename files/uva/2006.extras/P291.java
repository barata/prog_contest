
class Main {

	static boolean[][] graph = {
		{false,true,true,false,true},
		{true,false,true,false,true},
		{true,true,false,true,true},
		{false,false,true,false,true},
		{true,true,true,true,false}
	};
	
	static int[] path = new int[9];

	public static void main(String[] args) {
		DFS(0, 0);
	}
	
	static void DFS(int prev, int nivel) {
		path[nivel] = prev + 1;
		
		if (nivel == 8) {
			for (int i = 0; i < path.length; i++) {
				System.out.print(path[i]);
			}
			System.out.println();
		} else {
			for (int i = 0; i < graph.length; i++) {
				if (graph[prev][i]) {
					graph[prev][i] = graph[i][prev] = false;
					DFS(i, nivel + 1);
					graph[prev][i] = graph[i][prev] = true;
				}
			}
		}
	}

}
