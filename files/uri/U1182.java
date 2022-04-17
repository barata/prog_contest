import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());
		char op = br.readLine().charAt(0);
		
		double sum = 0;
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				double v = Double.parseDouble(br.readLine());
				
				if (j == c) {
					sum += v;
				}
			}
		}
		
		System.out.printf("%.1f\n", op == 'S' ? sum : sum / 12);
	}

}