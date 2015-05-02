import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int in = 0;
		int out = 0;

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x >= 10 && x <= 20) in++;
			else out++;
		}
		
		System.out.printf("%d in\n", in);
		System.out.printf("%d out\n", out);
	}

}