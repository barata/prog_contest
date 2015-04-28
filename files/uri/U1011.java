import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		sc.close();
		
		System.out.printf("VOLUME = %.3f\n", 4.0 / 3 * 3.14159 * r * r * r);
	}

}
