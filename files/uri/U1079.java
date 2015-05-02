import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			
			float a = Float.parseFloat(tks.nextToken());
			float b = Float.parseFloat(tks.nextToken());
			float c = Float.parseFloat(tks.nextToken());
			
			System.out.printf("%.1f\n", (a * 2 + b * 3 + c * 5) / 10.);
		}
	}

}