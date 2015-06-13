import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tks = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(tks.nextToken());
		int n;
		
		while ((n = Integer.parseInt(tks.nextToken())) <= 0);
		
		System.out.println((a + (a + n - 1)) * n / 2);
	}

}