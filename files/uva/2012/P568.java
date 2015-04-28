import java.util.Scanner;


class Main {

	static long[] table = new long[10001];
	
	static {
		table[0] = 1;
		for (int i = 1; i < table.length; i++) {
			long aux = table[i - 1] * i;
			while (aux % 10 == 0) aux /= 10;
			table[i] = aux % 1000000000;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			
			System.out.printf("%5d -> %d\n", n, table[n] % 10);
		}
	}

}
