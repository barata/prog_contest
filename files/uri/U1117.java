import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		float a = -1;
		
		while (true) {
			float b = Float.parseFloat(br.readLine());
			
			if (b >= 0 && b <= 10) {
				if (a < 0) {
					a = b;
				} else {
					System.out.printf("media = %.2f\n", (a + b) / 2);
					break;
				}
			} else {
				System.out.println("nota invalida");
			}
			
		}
	}

}
