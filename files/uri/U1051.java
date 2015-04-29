import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double salary = Double.parseDouble(br.readLine());
		
		double taxes = 0;
		
		if (salary > 4500) {
			taxes += (salary - 4500) * 0.28;
			taxes += 1500 * 0.18;
			taxes += 1000 * 0.08;
		} else if (salary > 3000) {
			taxes += (salary - 3000) * 0.18;
			taxes += 1000 * 0.08;
		} else if (salary > 2000) {
			taxes += (salary - 2000) * 0.08;
		}
		
		if (taxes > 0) System.out.printf("R$ %.2f\n", taxes);
		else System.out.println("Isento");
	}

}