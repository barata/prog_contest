import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tks.nextToken());
			int y = Integer.parseInt(tks.nextToken());
			
			if (y == 0) System.out.println("divisao impossivel");
			else System.out.printf("%.1f\n", (float) x / y);
		}
	}

}
