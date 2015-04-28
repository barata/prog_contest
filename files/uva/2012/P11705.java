import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(tks.nextToken());
		int n = Integer.parseInt(tks.nextToken());
		
		while (m != 0 || n != 0) {
		
			int[][] array = new int[m][n];
			
			for (int i = 0; i < m; i++) {
				tks = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					array[i][j] = Integer.parseInt(tks.nextToken());
				}
			}
			
			char[][] steps = new char[m][n];
			int[][] dist = new int[m][n];
			boolean[][] visited = new boolean[m][n];
			
			for (int i = 0; i < steps.length; i++) {
				for (int j = 0; j < steps[i].length; j++) {
					steps[i][j] = 'X';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			steps[0][0] = '*';
			dist[0][0] = 0;
			
			// process
			Pair min = extractMin(dist, visited);
			
			while (min != null) {
				int i = min.i;
				int j = min.j;
				for (int k = 0; k < i; k++) { // S
					if (k + array[k][j] == i) { // is adj
						if (dist[i][j] + 1 < dist[k][j]) {
							dist[k][j] = dist[i][j] + 1;
							steps[k][j] = 'S';
						}
					}
				}
				for (int k = 0; k < j; k++) { // E
					if (k + array[i][k] == j) { // is adj
						if (dist[i][j] + 1 < dist[i][k]) {
							dist[i][k] = dist[i][j] + 1;
							steps[i][k] = 'E';
						}
					}
				}
				for (int k = i+1; k < m; k++) { // N
					if (k - array[k][j] == i) { // is adj
						if (dist[i][j] + 1 < dist[k][j]) {
							dist[k][j] = dist[i][j] + 1;
							steps[k][j] = 'N';
						}
					}
				}
				for (int k = j+1; k < n; k++) { // W
					//i,k
					if (k - array[i][k] == j) { // is adj
						if (dist[i][j] + 1 < dist[i][k]) {
							dist[i][k] = dist[i][j] + 1;
							steps[i][k] = 'W';
						}
					}
				}
				
				min = extractMin(dist, visited);
			}
		
			// print
			for (int a = 0; a < steps.length; a++) {
				for (int b = 0; b < steps[a].length; b++) {
					System.out.print(steps[a][b]);
				}
				System.out.println();
			}
			System.out.println();
			
			
			tks = new StringTokenizer(br.readLine());
			m = Integer.parseInt(tks.nextToken());
			n = Integer.parseInt(tks.nextToken());
		}
	}

	private static Pair extractMin(int[][] dist, boolean[][] visited) {
		int minL = Integer.MAX_VALUE;
		int minC = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[i].length; j++) {
				if (!visited[i][j]) {
					if (dist[i][j] < min) {
						min = dist[i][j];
						minL = i;
						minC = j;
					}
				}
			}
		}
		
		if (min == Integer.MAX_VALUE) return null;
		
		visited[minL][minC] = true;
		Pair p = new Pair();
		p.i = minL;
		p.j = minC;
		return p;
	}

}

class Pair {
	public int i, j;
}