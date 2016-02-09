import java.io.BufferedReader;
import java.io.InputStreamReader;



class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			System.out.println(x + (isPerfeito(x) ? " eh perfeito" : " nao eh perfeito"));
		}
	}

	private static boolean isPerfeito(long x) {
		long sum = 0;
		
		for (int i = 1; i < x; i++) {
			if (x % i == 0) sum += i;
		}
		
		return sum == x;
	}

}