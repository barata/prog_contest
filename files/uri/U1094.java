import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int c = 0;
		int r = 0;
		int s = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			
			int amount = Integer.parseInt(tks.nextToken());
			String type = tks.nextToken();
			
			if ("C".equals(type)) c += amount;
			else if ("R".equals(type)) r += amount;
			else if ("S".equals(type)) s += amount;
		}
		
		int total = c + r + s;
		
		System.out.printf("Total: %d cobaias\n", total);
		System.out.printf("Total de coelhos: %d\n", c);
		System.out.printf("Total de ratos: %d\n", r);
		System.out.printf("Total de sapos: %d\n", s);
		System.out.printf("Percentual de coelhos: %.2f %%\n", c * 100. / total);
		System.out.printf("Percentual de ratos: %.2f %%\n", r * 100. / total);
		System.out.printf("Percentual de sapos: %.2f %%\n", s * 100. / total);
	}

}