import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int g = 1; g <= t; g++) {
			int n = Integer.parseInt(br.readLine());
			
			int high = 0;
			int low = 0;
			
			StringTokenizer tks = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(tks.nextToken());
			for (int i = 0; i < n - 1; i++) {
				int current = Integer.parseInt(tks.nextToken());
				
				if (current > prev) high++;
				else if (current < prev) low++;
				
				prev = current;
			}
			
			System.out.println("Case " + g + ": " + high + " " + low);
		}
	}
}