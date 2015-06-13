import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			System.out.printf("%d %d %d\n", i, i * i, i * i * i);
			System.out.printf("%d %d %d\n", i, i * i + 1, i * i * i + 1);
		}
	}

}