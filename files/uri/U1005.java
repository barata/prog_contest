import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		float a = Float.parseFloat(br.readLine());
		float b = Float.parseFloat(br.readLine());
		
		System.out.printf("MEDIA = %.5f\n", (3.5 * a + 7.5 * b) / 11);
	}

}