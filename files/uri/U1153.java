import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long factorial = 1;
		for (int i = 2; i <= n; i++) factorial *= i;
		System.out.println(factorial);
	}

}