import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		
		br.readLine();
		
		for (int g = 0; g < m; g++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			int k = tks.countTokens();
			int[][] matrix = new int[k][k];
			int[][] next = new int[k][k];
			int[] costs = new int[k];
			
			for (int i = 0; i < next.length; i++) {
				Arrays.fill(next[i], -1);
			}
			
			k = 0;
			do {
				for (int i = 0; i < matrix.length; i++) {
					int aux = Integer.parseInt(tks.nextToken());
					matrix[k][i] = aux < 0 ? Integer.MAX_VALUE>>2 : aux;
				}
				tks = new StringTokenizer(br.readLine());
			} while (++k < matrix.length);
			
			for (int i = 0; i < costs.length; i++) {
				costs[i] = Integer.parseInt(tks.nextToken());
			}
			
			floyd_warshall(matrix, costs, next);
			
			String line;
			boolean first = true;
			while (!"".equals(line = br.readLine()) && line != null) {
				tks = new StringTokenizer(line);
				int src = Integer.parseInt(tks.nextToken());
				int dst = Integer.parseInt(tks.nextToken());
				
				if (!first) System.out.println();
				first = false;
				
				System.out.println("From " + src + " to " + dst + " :");
				System.out.println("Path: " + src + getPath(matrix, next, src - 1, dst - 1) + dst);
				System.out.println("Total cost : " + matrix[src - 1][dst - 1]);
			}
			
			if (g < m - 1) System.out.println();
		}
	}
	
	private static String getPath(int[][] matrix, int[][] next, int i, int j) {
		if (matrix[i][j] == Integer.MAX_VALUE>>2) return "no path";
		int aux = next[i][j];
		if (aux == -1) return "-->";
		return getPath(matrix, next, i, aux) + (aux+1) + getPath(matrix, next, aux, j);
	}

	private static void floyd_warshall(int[][] matrix, int[] costs, int[][] next) {
		for (int k = 0; k < matrix.length; k++) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][k] + matrix[k][j] + costs[k] < matrix[i][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j] + costs[k];
						next[i][j] = k;
					}
				}
			}
		}
	}

}
