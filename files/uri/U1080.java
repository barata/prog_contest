import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		int pos = 1;
		
		for (int i = 1; i <= 100; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if (n > max) {
				max = n;
				pos = i;
			}
		}
		
		System.out.println(max);
		System.out.println(pos);
	}

}