import java.io.BufferedReader;
import java.io.InputStreamReader;



class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int g = 1; g <= n; g++) {
			long w = Long.parseLong(br.readLine());
			
			System.out.println((long) Math.floor((Math.sqrt(8 * w + 1) - 1) / 2));
		}
	}
}