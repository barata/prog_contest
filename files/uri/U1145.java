import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(tks.nextToken());
		int y = Integer.parseInt(tks.nextToken());
		
		for (int i = 1; i <= y; i++) {
			if ((i - 1) % x == 0) System.out.printf("%d", i);
			else System.out.printf(" %d", i);
			
			if (i % x == 0) System.out.printf("\n");
		}
	}

}