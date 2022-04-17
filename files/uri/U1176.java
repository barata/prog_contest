import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {
	
	static void fibo(int n) {
		long a = 0;
		long b = 1;

		fibo[0] = a;

		for (int i = 1; i < n; i++) {
			long c = a  + b;
			a = b;
			b = c;

			fibo[i] = a;
		}
	}
	
    static long[] fibo = new long[61];
    
    static {
            fibo(fibo.length);
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int value = Integer.parseInt(br.readLine());
			
			System.out.printf("Fib(%d) = %d\n", value, fibo[value]);
		}
	}

}