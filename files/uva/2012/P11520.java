import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int g = 1; g <= t; g++) {
			int n = Integer.parseInt(br.readLine());
			char[][] matrix = new char[n][n];
			
			for (int i = 0; i < n; i++) {
				br.readLine().getChars(0, n, matrix[i], 0);
			}
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (matrix[i][j] == '.')
						for (char c = 'A'; c <= 'Z'; c++)
							if ((j == 0 || matrix[i][j - 1] != c)
								&& (i == 0 || matrix[i - 1][j] != c)
								&& (j == n - 1 || matrix[i][j + 1] != c)
								&& (i == n - 1 || matrix[i + 1][j] != c)) {
								matrix[i][j] = c;
								break;
							}
			
			
			
			System.out.println("Case " + g + ":");
			for (int i = 0; i < matrix.length; i++) {
				System.out.println(String.valueOf(matrix[i]));
			}
		}
	}

}
