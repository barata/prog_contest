import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int mod = (n + 1) % 2;
		
		for (int i = 0; i < 6; i++) {
			System.out.println(n + mod + (i * 2));
		}
	}

}