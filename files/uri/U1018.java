import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		sc.close();
		
		int[] notes = { 100, 50, 20, 10, 5, 2, 1 };
		
		System.out.println(amount);
		
		for (int n : notes) {
			System.out.printf("%d nota(s) de R$ %d,00\n", amount / n, n);
			amount %= n;
		}
	}

}
