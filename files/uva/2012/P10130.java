import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nTests = Integer.parseInt(br.readLine());
		
		for (int g = 0; g < nTests; g++) {
			int nObjects = Integer.parseInt(br.readLine());
			
			int[] prices = new int[nObjects + 1];
			int[] weights = new int[nObjects + 1];
			
			for (int i = 1; i <= nObjects; i++) {
				StringTokenizer tks = new StringTokenizer(br.readLine());
				
				prices[i] = Integer.parseInt(tks.nextToken());
				weights[i] = Integer.parseInt(tks.nextToken());
			}
			
			int nPeople = Integer.parseInt(br.readLine());
			int max = 0;
			
			for (int k = 0; k < nPeople; k++) {
				int w = Integer.parseInt(br.readLine());
				
				int[][] array = new int[nObjects + 1][w + 1];
				
				for (int i = 1; i <= nObjects; i++) {
					for (int j = 1; j <= w; j++) {
						array[i][j] = Math.max(array[i - 1][j], j - weights[i] < 0 ? 0 : array[i - 1][j - weights[i]] + prices[i]);
					}
				}
				
				max += array[nObjects][w];
			}
			
			System.out.println(max);
		}
	}

}
