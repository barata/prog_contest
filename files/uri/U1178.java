import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double t = Double.parseDouble(br.readLine());
		
		for (int i = 0; i < 100; i++) {
			System.out.printf("N[%d] = %.4f\n", i, t);
			
			t /= 2;
		}
	}

}