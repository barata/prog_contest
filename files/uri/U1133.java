import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		
		for (int i = min + 1; i < max; i++) {
			if (i % 5 == 2 || i % 5 == 3) System.out.println(i);
		}
	}

}