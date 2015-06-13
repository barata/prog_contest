import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		int sum = 0;
		int n;
		
		while ((n = Integer.parseInt(br.readLine())) >= 0) {
			sum += n;
			count++;
		}
		
		System.out.printf("%.2f\n", (double) sum / count);
	}

}