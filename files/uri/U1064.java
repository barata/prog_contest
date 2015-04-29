import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String number;
		float sum = 0;
		int count = 0;
		
		while ((number = br.readLine()) != null) {
			if (Float.parseFloat(number) > 0) {
				sum += Float.parseFloat(number);
				count++;
			}
		}
		
		System.out.printf("%d valores positivos\n", count);
		System.out.printf("%.1f\n", sum / count);
	}

}