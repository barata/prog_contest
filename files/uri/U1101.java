import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(tks.nextToken());
		int n = Integer.parseInt(tks.nextToken());
		
		while (m > 0 && n > 0) {
			int sum = 0;
			StringBuilder sb = new StringBuilder();
			
			for (int i = Math.min(m, n); i <= Math.max(m, n); i++) {
				sb.append(i).append(' ');
				sum += i;
			}
			
			sb.append("Sum=").append(sum);
			
			System.out.println(sb.toString());
			
			tks = new StringTokenizer(br.readLine());
			m = Integer.parseInt(tks.nextToken());
			n = Integer.parseInt(tks.nextToken());
		}
	}

}