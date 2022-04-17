import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long value = Long.parseLong(br.readLine());
		
		for (int i = 0; i < 10; i++) {
			System.out.printf("N[%d] = %d\n", i, value);
			
			value *= 2;
		}
	}

}