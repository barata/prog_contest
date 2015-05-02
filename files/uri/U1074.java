import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) System.out.println("NULL");
			else {
				String parity = (x % 2 == 0 ? "EVEN" : "ODD");
				String sig = (x < 0 ? " NEGATIVE" : " POSITIVE");
				
				System.out.println(parity + sig);
			}
		}
	}

}