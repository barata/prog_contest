import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 100; i++) {
			double value = Double.parseDouble(br.readLine());
			
			if (value <= 10) {
				System.out.printf("A[%d] = %.1f\n", i, value);
			}
		}
	}

}