import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String number;
		int count = 0;
		
		while ((number = br.readLine()) != null) {
			if (Float.parseFloat(number) > 0) count++;
		}
		
		System.out.printf("%d valores positivos\n", count);
	}

}