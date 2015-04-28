import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {
	
	static long[] resp = new long[501];
	
	static {
		for (int i = 2; i < resp.length; i++) {
			for (int j = 1; j < i; j++) {
				resp[i] += gcd(j, i);
			}
			resp[i] += resp[i - 1];
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		while (n != 0) {
			
			System.out.println(resp[n]);
			
			
			n = Integer.parseInt(br.readLine());
		}
		
	}
	
	static long gcd(long m, long n) {
		if ((m % n) == 0)
			return n;
		else
			return gcd(n, m % n);
	}
}