import java.io.BufferedReader;
import java.io.InputStreamReader;



class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			System.out.println(x + (isPrime(x) ? " eh primo" : " nao eh primo"));
		}
	}

	private static boolean isPrime(long x) {
		long sqrt = Math.round(Math.sqrt(x));
		
		for (int i = 2; i <= sqrt; i++) {
			if (x % i == 0) return false;
		}
		
		return true;
	}

}