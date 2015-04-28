import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		sc.close();
		
		System.out.println(b > c && d > a && c + d > a + b && c > 0 && d > 0 && a % 2 == 0 ? "Valores aceitos" : "Valores nao aceitos");
	}

}
