import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int secs = sc.nextInt();
		sc.close();
		
		System.out.printf("%d:%d:%d\n", secs / 3600, (secs % 3600) / 60, (secs % 3600) % 60);
	}

}
