import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		sc.close();
		
		double delta = b * b - 4 * a * c;
		
		if (a == 0.0 || delta < 0) {
			System.out.println("Impossivel calcular");
		} else {
			System.out.printf("R1 = %.5f\n", (-b + Math.sqrt(delta)) / (2 * a));
			System.out.printf("R2 = %.5f\n", (-b - Math.sqrt(delta)) / (2 * a));
		}
	}
	
}
