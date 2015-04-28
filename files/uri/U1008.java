import java.util.Scanner;


class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int hours = sc.nextInt();
		float valuePerHour = sc.nextFloat();
		sc.close();
		
		System.out.printf("NUMBER = %d\n", number);
		System.out.printf("SALARY = U$ %.2f\n", hours * valuePerHour);
	}

}
