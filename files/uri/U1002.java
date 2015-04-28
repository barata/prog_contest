import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();
		sc.close();
		
		System.out.printf("A=%.4f\n", r * r * 3.14159);
	}

}
