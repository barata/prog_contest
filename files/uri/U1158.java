import java.util.Scanner;



class Main {

	public static void main(String[] args) { Scanner sc = new Scanner(System.in); try {
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if ((x & 1) == 0) x++;
			int y = sc.nextInt();
			
			System.out.println((x + y - 1) * y);
		}
		
		
	} finally { sc.close(); } }

}