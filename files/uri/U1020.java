import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int days = sc.nextInt();
		sc.close();
		
		System.out.printf("%d ano(s)\n", days / 365);
		System.out.printf("%d mes(es)\n", (days % 365) / 30);
		System.out.printf("%d dia(s)\n", (days % 365) % 30);
	}

}
