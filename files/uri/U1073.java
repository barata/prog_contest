import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		for (int i = 2; i <= n; i += 2) {
			System.out.printf("%d^2 = %d\n", i, i * i);
		}
		
	}

}