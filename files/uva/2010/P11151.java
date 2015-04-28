import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			StringBuilder builder = new StringBuilder(br.readLine());
			
			System.out.println(LCS_LENGTH(builder.toString(), builder.reverse().toString()));
		}
	}
	
	static int LCS_LENGTH(String palavra1, String palavra2) {
		int m = palavra1.length();
		int n = palavra2.length();
		
		int[][] c = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			
			for (int j = 1; j <= n; j++) {

				if (palavra1.charAt(i - 1) == palavra2.charAt(j - 1)) {
					c[i][j] = c[i - 1][j - 1] + 1;
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
				} else {
					c[i][j] = c[i][j - 1];
				}

			}
		}
		
		return c[m][n];
	}
}