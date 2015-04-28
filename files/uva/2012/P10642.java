import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer tks = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(tks.nextToken());
			int y1 = Integer.parseInt(tks.nextToken());
			int x2 = Integer.parseInt(tks.nextToken());
			int y2 = Integer.parseInt(tks.nextToken());
			
			System.out.println("Case " + i + ": " + (get(x2, y2) - get(x1, y1)));
		}
	}
	
	private static long get(long x, long y) {
		long diagonal = x + y;
		return (diagonal * diagonal + diagonal) / 2 + diagonal - y + 1;
	}

}
