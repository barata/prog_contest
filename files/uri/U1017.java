import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int speed = sc.nextInt();
		sc.close();
		
		System.out.printf("%.3f\n", (time * speed) / 12.);
	}

}
