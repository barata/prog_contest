import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tks.nextToken());
		int d = Integer.parseInt(tks.nextToken());
		int r = Integer.parseInt(tks.nextToken());
		
		while (n != 0 || d != 0 || r != 0) {
			int[] morning = new int[n];
			int[] evening = new int[n];
			
			tks = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				morning[i] = Integer.parseInt(tks.nextToken());
			}
			
			tks = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				evening[i] = Integer.parseInt(tks.nextToken());
			}
			
			Arrays.sort(morning);
			Arrays.sort(evening);
			
			int sum = 0;
			
			for (int i = 0; i < n; i++) {
				sum += Math.max(0, morning[i] + evening[n - (i + 1)] - d);
			}
			
			System.out.println(sum * r);
			
			
			tks = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tks.nextToken());
			d = Integer.parseInt(tks.nextToken());
			r = Integer.parseInt(tks.nextToken());
		}
	}

}
