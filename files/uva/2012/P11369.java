import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int g = 0; g < t; g++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer tks = new StringTokenizer(br.readLine());
			
			int[] items = new int[n];
			
			for (int i = 0; i < n; i++) {
				items[i] = Integer.parseInt(tks.nextToken());
			}
			
			Arrays.sort(items);
			int discount = 0;
			
			for (int i = items.length - 3; i >= 0; i -= 3) {
				discount += items[i];
			}
			
			System.out.println(discount);
		}
	}

}
