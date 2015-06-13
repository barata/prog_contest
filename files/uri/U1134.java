import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] freq = new int[4];
		int type;
		
		while ((type = Integer.parseInt(br.readLine())) != 4) {
			if (type >= 1 && type <= 3) freq[type]++;
		}
		
		System.out.println("MUITO OBRIGADO");
		System.out.println("Alcool: " + freq[1]);
		System.out.println("Gasolina: " + freq[2]);
		System.out.println("Diesel: " + freq[3]);
	}

}