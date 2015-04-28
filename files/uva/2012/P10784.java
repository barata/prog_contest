import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		int count = 0;
		
		while (n != 0) {
			System.out.println("Case " + ++count + ": " + (long) Math.ceil((3 + Math.sqrt(9 + 8 * n)) / 2));
			
			n = Long.parseLong(br.readLine());
		}
	}

}
