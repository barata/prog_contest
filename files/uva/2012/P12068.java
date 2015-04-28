import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int s = Integer.parseInt(br.readLine());
		
		for (int k = 1; k <= s; k++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(tks.nextToken());
			int[] numbers = new int[n];
			
			long num = 1;
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(tks.nextToken());
				numbers[i] = x;
				num *= x;
			}
			
			long den = 0;
			for (int i = 0; i < n; i++) {
				den += num / numbers[i];
			}
			
			num *= n;
			
			long gcd = gcd(num, den);
			System.out.println("Case " + k + ": " + (num / gcd) + "/" + den / gcd);
		}
	}
	
	static long gcd(long m, long n) {
		if ((m % n) == 0)
			return n;
		else
			return gcd(n, m % n);
	}

}
