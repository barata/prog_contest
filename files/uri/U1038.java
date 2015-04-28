import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
	
	private static final float[] TABLE = { 0.0f, 4.0f, 4.5f, 5.0f, 2.0f, 1.5f };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(tks.nextToken());
		int y = Integer.parseInt(tks.nextToken());
		
		System.out.printf("Total: R$ %.2f\n", TABLE[x] * y);
	}

}