import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {
	
	static long[] fib = new long[81];
	
	static {
		fib[0] = fib[1] = 1;
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			
			System.out.println(fib[n]);
		}
	}

}
