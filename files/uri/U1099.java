import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tks.nextToken());
			int y = Integer.parseInt(tks.nextToken());
			
			int sum = 0;
			
			for (int j = Math.min(x, y) + 1; j < Math.max(x, y); j++) {
				if (j % 2 != 0) sum += j;
			}
			
			System.out.println(sum);
		}
	}

}
