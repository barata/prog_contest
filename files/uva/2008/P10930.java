import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int nCase = 0;
		
		while ((line = br.readLine()) != null) {
			StringTokenizer tks = new StringTokenizer(line);
			int d = Integer.parseInt(tks.nextToken());
			
			boolean[][] table = new boolean[2][1001];
			table[0][0] = true;
			int previous = 0;
			boolean isASeq = true;
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < d; i++) {
				int a = Integer.parseInt(tks.nextToken());
				sb.append(" ").append(a);
				
				if (a <= previous || table[0][a]) {
					isASeq = false;
					while (tks.hasMoreTokens()) {
						sb.append(" ").append(tks.nextToken());
					}
					break;
				}
				
				for (int k = a; k <= 1000; k++) {
					table[1][k] = table[0][k - a];
				}
				for (int k = a; k <= 1000; k++) {
					table[0][k] |= table[1][k];
				}
				
				
				
				previous = a;
			}
			
			
			
			
			System.out.println("Case #" + (++nCase) + ":" + sb);
			if (isASeq) System.out.println("This is an A-sequence.");
			else System.out.println("This is not an A-sequence.");
		}
	}

}
