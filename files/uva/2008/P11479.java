import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int g = 1; g <= t; g++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			
			long n1 = Long.parseLong(tks.nextToken());
			long n2 = Long.parseLong(tks.nextToken());
			long n3 = Long.parseLong(tks.nextToken());
			
			long min = Math.min(Math.min(n1, n2), n3);
			long max = Math.max(Math.max(n1, n2), n3);
			long mid = n1 + n2 + n3 - (min + max);

			String result;
			
			if (n1 <= 0 || n2 <= 0 || n3 <= 0 || min + mid <= max) result = "Invalid";
			else if (n1 != n2 && n2 != n3 && n1 != n3) result = "Scalene";
			else if (n1 == n2 && n2 == n3) result = "Equilateral";
			else result = "Isosceles";
			
			
			
			System.out.println("Case "+g+": "+result);
		}
		
	}
	
}