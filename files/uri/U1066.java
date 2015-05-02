import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String number;
		int even = 0;
		int odd = 0;
		int pos = 0;
		int neg = 0;
		
		while ((number = br.readLine()) != null) {
			int n = Integer.parseInt(number);
			
			if (n % 2 == 0) even++;
			else odd++;
			
			if (n > 0) pos++;
			else if (n < 0) neg++;
		}
		
		System.out.printf("%d valor(es) par(es)\n", even);
		System.out.printf("%d valor(es) impar(es)\n", odd);
		System.out.printf("%d valor(es) positivo(s)\n", pos);
		System.out.printf("%d valor(es) negativo(s)\n", neg);
	}

}