import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n;
		
		while ((n = Long.parseLong(br.readLine())) >= 0) {
			System.out.println(n * (n+1) / 2 + 1);
		}
	}

}
