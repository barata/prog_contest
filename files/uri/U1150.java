import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int z;
		
		while ((z = Integer.parseInt(br.readLine())) <= x);
		
		double delta = (x - 0.5) * (x - 0.5) + 2 * z;
		double n = 0.5 - x + Math.sqrt(delta);
		
		System.out.println((long) Math.ceil(n));
	}

}