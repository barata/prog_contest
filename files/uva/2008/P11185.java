import java.io.BufferedReader;
import java.io.InputStreamReader;



class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		while (n >= 0) {
			System.out.println(Integer.toString(n, 3));
			
			
			n = Integer.parseInt(br.readLine());
		}
	}
}