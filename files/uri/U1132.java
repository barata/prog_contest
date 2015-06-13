import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		long sum = 0;
		
		for (int i = min; i <= max; i++) {
			if (i % 13 != 0) sum += i;
		}
		
		System.out.println(sum);
	}

}