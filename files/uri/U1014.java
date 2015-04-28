import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int distance = sc.nextInt();
		float consumption = sc.nextFloat();
		sc.close();
		
		System.out.printf("%.3f km/l\n", distance / consumption);
	}

}
