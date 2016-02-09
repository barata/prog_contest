import java.util.Scanner;



class Main {

	public static void main(String[] args) { Scanner sc = new Scanner(System.in); try {
		
		int x;
		
		while ((x = sc.nextInt()) != 0) {
			if ((x & 1) != 0) x++;
			int y = 5;
			
			System.out.println((x + y - 1) * y);
		}
		
	} finally { sc.close(); } }

}