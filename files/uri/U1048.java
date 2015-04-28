import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		double salary = Double.parseDouble(tks.nextToken());
		
		double rate;
		if (salary > 2000) rate = 0.04;
		else if (salary > 1200) rate = 0.07;
		else if (salary > 800) rate = 0.10;
		else if (salary > 400) rate = 0.12;
		else rate = 0.15;

		System.out.printf("Novo salario: %.2f\nReajuste ganho: %.2f\nEm percentual: %d %%\n",
				salary * (1 + rate),
				salary * rate,
				(int) (rate * 100));
	}
	
}