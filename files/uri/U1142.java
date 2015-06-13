import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			System.out.printf("%d %d %d PUM\n", i * 4 + 1, i * 4 + 2, i * 4 + 3);
		}
	}

}