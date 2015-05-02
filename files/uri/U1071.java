import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		int sum = 0;

		for (int i = Math.min(x, y) + 1; i < Math.max(x, y); i++) {
			if (i % 2 != 0) sum += i;
		}
		
		System.out.println(sum);
	}

}