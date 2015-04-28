import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		System.out.println(maiorAB(a, maiorAB(b, c)) + " eh o maior");
	}
	
	private static int maiorAB(int a, int b) {
		return (a + b + Math.abs(a - b)) / 2;
	}

}
