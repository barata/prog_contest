import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			int value = Integer.parseInt(br.readLine());
			
			System.out.printf("X[%d] = %d\n", i, value <= 0 ? 1 : value);
		}
	}

}