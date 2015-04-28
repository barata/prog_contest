import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		float a = Float.parseFloat(br.readLine());
		float b = Float.parseFloat(br.readLine());
		float c = Float.parseFloat(br.readLine());
		
		System.out.printf("MEDIA = %.1f\n", (2 * a + 3 * b + 5 * c) / 10);
	}

}